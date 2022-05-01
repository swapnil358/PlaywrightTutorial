package com.playwright;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RelativeCSSSelctors {
    static Playwright pw;
    static Page page;


    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://selectorshub.com/xpath-practice-page/");

    }

    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }


    @Test
    public void leftOf() {
        Locator locator = page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))");
        locator.first().click();

        leftOfMethod("Jordan.Mathews");
    }


    @Test
    public void aboveOf()  {
        Locator locator = page.locator("a:above(:text('Joe.Root'))");
        System.out.println(locator.first().textContent());

    }


    @Test
    public void belowOf()  {
        Locator locator = page.locator("a:below(:text('Joe.Root'))");
        System.out.println(locator.first().textContent());

    }

  //  @Test
    public void leftOfMethod(String userName) {
        Locator locator = page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))");
        locator.first().click();
    }
}
