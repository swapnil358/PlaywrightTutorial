package com.playwright;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class locators {
    static Playwright pw;
    static Page page;

    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://demo.opencart.com/index.php?route=account/login");

    }

    @AfterClass
    public static void tearDown() {
//        page.close();
//        pw.close();
    }

    @Test
    public void test() {
        Locator links = page.locator("text=Privacy Policy");
        System.out.println(links.count());
        for (int i = 0; i < links.count(); i++) {
            String content = links.nth(i).textContent();
            System.out.println(content);
            if (content.equalsIgnoreCase("Service Privacy Policy")) {
                links.click();
            }
        }
    }

    @Test
    public void test2() {
        String textContent = page.locator("h2:has-text('New Customer')").textContent();
        // System.out.println(textContent);

        String textContent1 = page.locator("text= Your Store").first().textContent();
        //System.out.println(textContent1);

        String s = page.locator("'Your Store'").textContent();
        System.out.println(s);
    }


}
