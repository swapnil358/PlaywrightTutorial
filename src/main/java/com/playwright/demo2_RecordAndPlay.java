package com.playwright;


import com.microsoft.playwright.*;

import java.nio.file.Paths;


//Code gen command -  mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="codegen https://www.amazon.com/"

public class demo2_RecordAndPlay {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();

            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true));
            // Open new page
            Page page = context.newPage();

            // Go to https://ui.cogmento.com/
            page.navigate("https://ui.cogmento.com/");

            // Click [placeholder="E-mail address"]
            page.click("[placeholder=\"E-mail address\"]");

            // Click text=Sign Up
            page.click("text=Sign Up");
            // assert page.url().equals("https://api.cogmento.com/register/");

            // Click [placeholder="Email Address"]
            page.click("[placeholder=\"Email Address\"]");

            // Fill [placeholder="Email Address"]
            page.fill("[placeholder=\"Email Address\"]", "swapnil.b@gmail.com");

            // Click i
            page.click("i");

            // Click text=Indonesia (+62)
            page.click("text=Indonesia (+62)");

            // Click [placeholder="Phone Number"]
            page.click("[placeholder=\"Phone Number\"]");

            // Fill [placeholder="Phone Number"]
            page.fill("[placeholder=\"Phone Number\"]", "1234567895");

            // Check input[name="terms"]
            page.check("input[name=\"terms\"]");

            // Click text=Sign Up
            page.click("text=Sign Up");
            // assert page.url().equals("https://api.cogmento.com/register/complete/2a519a70-6266-4bc7-a908-482ddd862ff3/");

            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));

        }
    }
}
