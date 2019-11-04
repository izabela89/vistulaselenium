package org.vistula.selenium.test.homework;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    private WebDriver driver;

    public SearchResultPage (WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSidebarLink() {
        new WebDriverWait(driver, 6, 1000);
    }

    public void verifyLinkUrl(String url) {
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, url );
    }

    public void verifyLinkUrlNotEquals(String url) {
        String URL = driver.getCurrentUrl();
        Assert.assertNotEquals(URL, url );
    }

}
