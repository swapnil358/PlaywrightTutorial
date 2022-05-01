package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RelativeCSSSelectorDemo {
    static Playwright pw;
    static Page page;


    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");

    }

    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }


    @Test
    public void fillForm() {
        page.locator("input:below(label:text('First Name'))").first().fill("Swapnil");
        page.locator("input:below(label:text('Last Name'))").first().fill("bodade");
        page.locator("input:below(label:text('Email'))").first().fill("abc@gmail.com");
        page.locator("input:above(label:text('We respect your privacy. By submitting, '))").first().click();

    }
}
