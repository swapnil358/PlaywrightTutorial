package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class demo1 {

    public static void main(String[] args) {

        Playwright pw = Playwright.create();


        //Below statement will launch chromium browser
        // Browser browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        //To launch actual chrome browser
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setChannel("chrome");
        launchOptions.setHeadless(false);

        Browser browser2 = pw.chromium().launch(launchOptions);


        Page page = browser2.newPage();

        page.navigate("https://www.amazon.com");

        String title = page.title();
        System.out.println("page title is: " + title);

        String url = page.url();
        System.out.println("Url is : " + url);

        browser2.close();

        pw.close();
    }
}
