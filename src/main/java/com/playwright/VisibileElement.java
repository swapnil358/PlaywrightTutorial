package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

public class VisibileElement {
    static Playwright pw;
    static Page page;



    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://www.amazon.com/");

    }

    @AfterClass
    public static void tearDown() {
        page.close();
       pw.close();
    }

    @Test
    public void test() {
        List<String> texts = page.locator("a:visible").allInnerTexts();

        for (int i = 0; i < texts.size(); i++) {
        //    System.out.println(texts.get(i));
        }

//Print the count of the images where those are having true visible property
        int imagesCount = page.locator("xpath=//img >> visible=true").count();
        System.out.println(imagesCount);


    }
}
