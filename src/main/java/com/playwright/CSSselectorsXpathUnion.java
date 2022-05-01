package com.playwright;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CSSselectorsXpathUnion {
    static Playwright pw;
    static Page page;



    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://academy.naveenautomationlabs.com");

    }


    @Test
    public void miltpleNameByCSS(){
        Locator locator = page.locator("a:has-text('Login'), a:has-text('SignIn'), a:has-text('LOGIN'), a:has-text('SIGN-IN')");
        locator.click();
    }


    @Test
    public void miltpleNameByXpath() {
        Locator locator = page.locator("//span[text()='sign in'] | a[text()='Login']");
        locator.click();
    }

    @Test
    public void pairOfWebElement(){
        Locator locator = page.locator("span:has-text('Store'), a:has-text('Login')");
        locator.allInnerTexts().forEach(e -> System.out.println(e));
        locator.count();
    }


    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }

}
