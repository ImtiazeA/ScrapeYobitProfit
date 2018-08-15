package scraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetDataFromYobit implements Runnable {
    public GetDataFromYobit() {
        System.out.println("Scraping....");
    }

    static WebDriver driver;

    static {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=F:/W10/Chrome/User Data/selenium");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://yobit.net/en/dice/");
    }

    public void run() {

        WriteToFile.writeToFile(driver.findElement(By.xpath("//table[contains(@id, 'DataTables_Table_0')]")).getAttribute("outerHTML"));

    }
}
