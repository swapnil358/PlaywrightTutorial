package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FrameHandling {

    static Playwright pw;
    static Page page;

    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://demoqa.com/frames");
    }

    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }

    //To handle frame we can use frameLocator() and Frame() method

    @Test
    public void test1() {
        String content =   page.frameLocator("iframe[id='frame1']").locator("h1").textContent();
        //System.out.println(content);`

        String content1 = page.frame("iframe[id='frame1']").locator("h1").textContent();
        System.out.println(content1);

    }
}
