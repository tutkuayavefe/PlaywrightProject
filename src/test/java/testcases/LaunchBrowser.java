package testcases;

import com.microsoft.playwright.*;

import java.awt.*;

public class LaunchBrowser {

    public static void main(String[] args) throws InterruptedException {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();


        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize((int) width, (int) height)); //https://whatismyviewport.com/
        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
