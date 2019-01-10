# coding=utf-8
import time
from selenium import webdriver
from selenium.webdriver.common.action_chains import ActionChains

def login(username, password, driver):
    element1 = driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-list/ion-item[1]/div[1]/div/ion-input")
    ActionChains(driver).click(element1).send_keys(username).perform()
    element2 = driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/ion-list/ion-item[2]/div[1]/div/ion-input")
    ActionChains(driver).click(element2).send_keys(password).perform()
    driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/button").click()

def register(username, password1, password2, driver):
    driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-login/ion-content/div[2]/div/h6").click()
    time.sleep(3)
    element1 = driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/ion-list/ion-item[1]/div[1]/div/ion-input")
    ActionChains(driver).click(element1).send_keys(username).perform()
    element2 = driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/ion-list/ion-item[2]/div[1]/div/ion-input")
    ActionChains(driver).click(element2).send_keys(password1).perform()
    element3 = driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/ion-list/ion-item[3]/div[1]/div/ion-input")
    ActionChains(driver).click(element3).send_keys(password2).perform()
    driver.find_element_by_xpath("/html/body/ion-app/ng-component/ion-nav/page-register/ion-content/div[2]/button[2]").click()

def publishWord(content, driver):
    driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/page-home/ion-header/ion-navbar/div[2]/button').click()
    time.sleep(3)
    element = driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/textarea')
    ActionChains(driver).click(element).send_keys(content).perform()
    driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/button').click()

def publishImage(image, driver):
    driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/page-home/ion-header/ion-navbar/div[2]/button').click()
    time.sleep(3)
    element = driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/ion-input/input')
    element.send_keys(image)
    time.sleep(10)
    driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/button').click()

def publishWordAndImage(content, image, driver):
    driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/page-home/ion-header/ion-navbar/div[2]/button').click()
    time.sleep(3)
    element1 = driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/textarea')
    ActionChains(driver).click(element1).send_keys(content).perform()
    element2 = driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/ion-input/input')
    element2.send_keys(image)
    driver.find_element_by_xpath('//*[@id="tabpanel-t0-0"]/ng-component/ion-content/div[2]/button').click()

def usecaseLogin1(driver):
    login('213', '321323', driver)

def usecaseLogin2(driver):
    login('lxy1', '12345', driver)

def usecaseLogin3(driver):
    login('lxy', '111', driver)

def usecaseLogin4(driver):
    login('lxy2', '111', driver)

def usecaseLogin5(driver):
    login('lxy', '112', driver)

def usecaseLogin6(driver):
    login('lxy2', '112', driver)

def usecaseShow(driver):
    login('213', '321323', driver)
    time.sleep(3)
    publishWord('软件测试', driver)

def usecasePublishWord(driver):
    login('213', '321323', driver)
    time.sleep(3)
    publishWord('软件测试', driver)

def usecasePublishWordAndImage(driver):
    login('213', '321323', driver)
    time.sleep(3)
    publishWordAndImage('great!', r'C:\Users\li\Desktop\win.png', driver)

def usecaseSequence(driver):
    login('213', '321323', driver)
    time.sleep(3)
    publishWord('new', driver)

def usecaseRenewButton(driver):
    driver2 = webdriver.Chrome()
    driver2.maximize_window()  # 最大化浏览器窗口
    driver2.implicitly_wait(8)  # 设置隐式时间等待
    driver2.get("http://localhost:8100")
    time.sleep(2)

    login('213', '321323', driver2)
    login('lxy1', '12345', driver)
    time.sleep(3)
    publishWord('perfect', driver)

def usecaseMoreButton(driver):
    login('213', '321323', driver)
    time.sleep(3)


def usecaseRegister1(driver):
    register('213', '321323', '321323', driver)

def usecaseRegister2(driver):
    register('lxy1', '12345', '12345', driver)

def usecaseRegister3(driver):
    register('lxy', '111', '111', driver)

def usecaseRegister4(driver):
    register('213', '123456789', '123456789', driver)
#def indexPage():
    #driver.find_element_by_xpath("//ion-tabs/ion-tab[1]").click()

#def myPage():
    #driver.find_element_by_xpath("//ion-tabs/ion-tab[2]").click()

driver = webdriver.Chrome()
driver.maximize_window()
driver.implicitly_wait(8)

driver.get("http://localhost:8100")

time.sleep(2)

time.sleep(10)
driver.quit()