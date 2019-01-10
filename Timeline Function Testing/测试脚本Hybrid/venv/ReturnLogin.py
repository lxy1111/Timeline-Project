import time
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from TestCaseInfo import TestCaseInfo
from TestReport import TestReport

class Test_ReturnLogin():
    def register(self, driver):
        driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/h6").click()
        time.sleep(3)
        driver.find_element_by_xpath('/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/button[1]').click()
    # Setup
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.implicitly_wait(8)
        self.base_url = "http://localhost:8100"
        # test case information
        self.testcaseinfo = TestCaseInfo(id="6", name="Return to login Successfully", owner="LJL")
        self.testResult = TestReport()

    def test_Login(self):
        self.testcaseinfo.starttime = str(time.asctime())
        self.driver.get(self.base_url)
        time.sleep(2)
        self.register(self.driver)
        if self.driver.find_element_by_xpath('/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/h2[2]').is_displayed() == True:
            self.testcaseinfo.result = "Pass"
        else:
            self.testcaseinfo.result = "Failed"
        self.testcaseinfo.endtime = str(time.asctime())

    # tearDown
    def tearDown(self):
        self.driver.quit()
        self.testResult.WriteHTML(self.testcaseinfo)