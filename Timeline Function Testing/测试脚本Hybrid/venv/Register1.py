import time
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from TestCaseInfo import TestCaseInfo
from TestReport import TestReport

class Test_Register1():
    def register(self, username, password1, password2, driver):
        driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/h6").click()
        time.sleep(3)
        element1 = driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/ion-list/ion-item[1]/div[1]/div/ion-input")
        ActionChains(driver).click(element1).send_keys(username).perform()
        element2 = driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/ion-list/ion-item[2]/div[1]/div/ion-input")
        ActionChains(driver).click(element2).send_keys(password1).perform()
        element3 = driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/ion-list/ion-item[3]/div[1]/div/ion-input")
        ActionChains(driver).click(element3).send_keys(password2).perform()
        driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/button[2]").click()
    # Setup
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.implicitly_wait(8)
        self.base_url = "http://localhost:8100"
        # test case information
        self.testcaseinfo = TestCaseInfo(id="2", name="Register Successfully", owner="LJL")
        self.testResult = TestReport()

    def test_Login(self):
        self.testcaseinfo.starttime = str(time.asctime())
        self.driver.get(self.base_url)
        time.sleep(2)
        self.register('231', '321323', '321323', self.driver)
        if self.driver.find_element_by_xpath('/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/h2[1]').is_displayed() == True:
            self.testcaseinfo.result = "Pass"
        else:
            self.testcaseinfo.result = "Failed"
        self.testcaseinfo.endtime = str(time.asctime())

    # tearDown
    def tearDown(self):
        self.driver.quit()
        self.testResult.WriteHTML(self.testcaseinfo)