import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FireFox2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ru.onlinemschool.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.
                xpath("//img[@src='//ru.onlinemschool.com/skins/logo2.png']")));
        List<WebElement> content_2 = driver.findElements(By.
                xpath("//*[@class='oms_definition0']"));

        System.out.println("Вывод:\n" + header.getAttribute("baseURI"));
        for (int i = 0; i < content_2.size(); i++) {
            System.out.println(content_2.get(i).getAttribute("textContent").
                    replaceAll("\\s+", " "));
        }

        WebElement firstElement = driver.findElement(By.xpath("//div[contains(@class, 'oms_vmenu_cell') and contains(@onclick, \"go('ru.onlinemschool.com/math/practice/')\")]"));
        firstElement.click();

        WebElement secondElement = driver.findElement(By.cssSelector("a[href='//ru.onlinemschool.com/math/practice/arithmetic/addition_10/'"));
        secondElement.click();

        driver.quit();
    }
}
