package com.playwright;

import com.microsoft.playwright.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReactApplicationSelectors {
    static Playwright pw;
    static Page page;

    //Download chrome plugin 'react developer tools'
    //playwright.$("react_component_name[attribute='value']")


    @BeforeClass
    public static void setUp() {

        pw = Playwright.create();
        Browser launch = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = launch.newPage();
        page.navigate("https://www.netflix.com/in/");

    }

    @AfterClass
    public static void tearDown() {
        page.close();
        pw.close();
    }


    @Test
    public void firstElement() {
        Locator email = page.locator("_react=p[name='email'] >> input").first();
        email.click();
        email.fill("abc@gmail.com");
    }
}
