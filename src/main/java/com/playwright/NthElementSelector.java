package com.playwright;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class NthElementSelector {
    static Playwright pw;
    static Page page;

     /*

    n-th element selector
    button button button button
    "button >> nth=0"  //first
    "button >> nth=-1" //last


     */

    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://www.bigbasket.com/");

    }

    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }


    @Test
    public void firstElement() {
        Locator locator = page.locator("div .footer-links li a");
        System.out.println(locator.nth(0).textContent());
    }

    @Test
    public void lastElement() {
        Locator locator = page.locator("div .footer-links li a");
        System.out.println(locator.nth(-1).textContent());
    }

}
