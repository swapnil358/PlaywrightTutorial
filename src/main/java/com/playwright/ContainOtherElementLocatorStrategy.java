package com.playwright;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class ContainOtherElementLocatorStrategy {
    static Playwright pw;
    static Page page;



    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://www.orangehrm.com/hris-hr-software-demo/");

    }


    @Test
    public void selectCountryIndia(){
        Locator locator = page.locator("select#Form_submitForm_Country:has(option[value='India'])");
        locator.allInnerTexts().forEach(e-> System.out.println(e));
    }




    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }
}
