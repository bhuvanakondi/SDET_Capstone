from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

import pytest

@pytest.fixture

def driver():
    chrome_options = webdriver.ChromeOptions()
    chrome_options.add_argument("--headless")
    driver_manager = webdriver.ChromeDriverManager()
    driver = webdriver.Chrome(options=chrome_options, executable_path=driver_manager.install())
    yield driver
    driver.quit()

@pytest.fixture
def wait(driver):
    return WebDriverWait(driver, 10)

def test_wordpress_theme_search(driver, wait):
    driver.get("https://wordpress.org/")

    # to Verify page title
    assert driver.title == "WordPress › Blog Tool, Publishing Platform, and CMS"

    # to do mouse Hover over Download & Extend and click Themes
    download_extend_link = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "a[data-nav_id='download']")))
    themes_link = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "a[data-nav_id='themes']")))
    webdriver.ActionChains(driver).move_to_element(download_extend_link).click(themes_link).perform()

    #to Search for a specific theme
    search_bar = wait.until(EC.element_to_be_clickable((By.CSS_SELECTOR, "input#themes-filter-search-input")))
    search_bar.send_keys("Astra")

    # to Verify theme names are displayed
    theme_titles = driver.find_elements_by_css_selector(".theme-search-result__title")
    assert len(theme_titles) > 0
    for title in theme_titles:
        assert title.text.strip() != ""

if __name__ == "__main__":
    pytest.main()