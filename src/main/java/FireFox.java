import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FireFox {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.mathway.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement header_1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//a[@class=\"logo-mathway sprite logo-header\"]")));
        List<WebElement> content_1 = driver.findElements(By.
                xpath("//*[@data-subject]"));

        System.out.println("Вывод:\n" + header_1.getAttribute("host"));
        for (int i = 0; i < content_1.size(); i++) {
            System.out.println(content_1.get(i).getAttribute("text").
                    replaceAll("\\s+", ""));
        }

        driver.quit();

    }
}
