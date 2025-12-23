import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class selentask {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        WebElement searchbar = driver.findElement(By.xpath("//input[@class='gh-search-input gh-tb ui-autocomplete-input']"));
        searchbar.sendKeys("buffy the vampire slayer doll");
        searchbar.sendKeys(Keys.RETURN);
        Thread.sleep(2000);
        List<WebElement> listCount = driver.findElements(By.xpath("//li[@class='s-card s-card--horizontal s-card--dark-solt-links-blue']"));
        System.out.println("RESULT COUNT: " + listCount.size());
        WebElement productname= driver.findElement(By.xpath("//div//span[text()='New Buffy The Vampire Slayer Limited Edition Collector Series Figure 9\" 1999'][1]"));
        productname.click();

        ArrayList<String> name=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(name.get(1));
        Thread.sleep(2000);
        WebElement addtocart= driver.findElement(By.xpath("//a[@id='atcBtn_btn_1']"));
        addtocart.click();
        Thread.sleep(2000);
        WebElement gotocart= driver.findElement(By.xpath("//a[@href='https://cart.ebay.com?_trksid=p4540640.m167481.l8876']"));

        gotocart.click();
        Thread.sleep(2000);
        driver.close();








    }
}