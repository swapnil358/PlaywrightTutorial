package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class GetListUsingInnerTex {

    static Playwright pw;
    static Page page;

    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://www.orangehrm.com/features/hr-administration/");

    }

    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }

    @Test
    public void test1() {
        List<String> allInnerTexts = page.locator("li[class='main-list']").allInnerTexts();
        allInnerTexts.forEach(System.out::println);
    }


    @Test
    public void test2() {
        page.locator("text=BOOK A FREE DEMO").first().click();
        //select#Form_submitForm_Country:has(option[value='India'
        List<String> innerTexts = page.locator("select#Form_submitForm_Country").allInnerTexts();
        innerTexts.forEach(System.out::println);
    }
}
