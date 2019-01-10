import time
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains
from TestCaseInfo import TestCaseInfo
from TestReport import TestReport

class Test_PublishWord():
    def publishWord(self, username, password, content, driver):
        element1 = driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-list/ion-item[1]/div[1]/div/ion-input")
        ActionChains(driver).click(element1).send_keys(username).perform()
        element2 = driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-list/ion-item[2]/div[1]/div/ion-input")
        ActionChains(driver).click(element2).send_keys(password).perform()
        driver.find_element_by_xpath(
            "/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/button").click()
        time.sleep(3)
        driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/page-home/ion-header/ion-navbar/div[2]/button').click()
        time.sleep(3)
        element3 = driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/textarea')
        ActionChains(driver).click(element3).send_keys(content).perform()
        driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/button').click()
    # Setup
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.implicitly_wait(8)
        self.base_url = "http://localhost:8100"
        # test case information
        self.testcaseinfo = TestCaseInfo(id="3", name="Publish word Successfully", owner="LJL")
        self.testResult = TestReport()

    def test_Login(self):
        self.testcaseinfo.starttime = str(time.asctime())
        self.driver.get(self.base_url)
        time.sleep(2)
        self.publishWord('213', '321323', '软件测试', self.driver)
        if self.driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/page-home/ion-header/ion-navbar/div[2]/ion-title/div').is_displayed() == True:
            self.testcaseinfo.result = "Pass"
        else:
            self.testcaseinfo.result = "Failed"
        self.testcaseinfo.endtime = str(time.asctime())

    # tearDown
    def tearDown(self):
        self.driver.quit()
        self.testResult.WriteHTML(self.testcaseinfo)