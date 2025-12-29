import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.Set;

public class seleniumtask2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lambdatest.com/selenium-playground/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        System.out.println("Dynamic data Loading");
        WebElement dataLoad= driver.findElement(By.xpath("//a[contains(text(),'Dynamic Data Loading')]"));
        dataLoad.click();
        WebElement getUser=driver.findElement(By.id("save"));
        getUser.click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement name= driver.findElement(By.id("loading"));
        name.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("loading"), "First Name"
        ));
        System.out.println(name.getText());
        driver.navigate().back();
        System.out.println();


        System.out.println("Context Menu(alert handles)");
        WebElement contextMenu=driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]"));
        contextMenu.click();
        WebElement divBox= driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(divBox).build().perform();
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.navigate().back();
        System.out.println();



        System.out.println("Table pagination");
        WebElement tablePagination=driver.findElement(By.xpath("//a[contains(text(),'Table Pagination')]"));
        tablePagination.click();
        WebElement selectnoofrows= driver.findElement(By.id("maxRows"));
        selectnoofrows.click();
        WebElement option= driver.findElement(By.xpath("//option[@value=\"10\"]"));
        option.click();
        WebElement pageNo=driver.findElement(By.xpath("//span[contains(text(),\"3\")]"));
        pageNo.click();
        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr[not(contains(@style,'display: none'))]"));
        String email = rows.get(6).findElements(By.tagName("td")).get(3).getText();
        String phone = rows.get(6).findElements(By.tagName("td")).get(4).getText();
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        driver.navigate().back();
        System.out.println();


        System.out.println("Window pop up modal");
        WebElement windowPop=driver.findElement(By.xpath("//a[contains(text(),'Window Popup Modal')]"));
        windowPop.click();
        WebElement followAll= driver.findElement(By.xpath("//a[@id=\"followall\"]"));
        followAll.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            driver.switchTo().window(window);
            if (!window.equals(parentWindow)) {
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                System.out.println("URL: " + driver.getCurrentUrl());
                System.out.println("Title: " + driver.getTitle());
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        driver.navigate().back();
        System.out.println();



        System.out.println("Nested frames");
        WebElement nestedFrames=driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]"));
        nestedFrames.click();
        driver.switchTo().frame("frame-top");
        System.out.println(driver.findElement(By.tagName("p")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");

        List<WebElement> frames = driver.findElements(By.tagName("frame"));
        for (WebElement frame : frames) {
            driver.switchTo().frame(frame);
            System.out.println(driver.findElement(By.tagName("body")).getText());
            driver.switchTo().parentFrame();
        }
        driver.switchTo().defaultContent();
        driver.navigate().back();
        System.out.println();

        WebElement bootsrapModals = driver.findElement(By.xpath("//a[contains(text(),'Bootstrap Modals')]"));
        bootsrapModals.click();
 WebElement launchModal1 = driver.findElement(By.xpath("//button[@data-target='#myModal']"));
        launchModal1.click();
        WebElement saveChanges = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='myModal']//*[text()='Save Changes']")));
        saveChanges.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("myModal")));
        WebElement launchModal2 = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-target='#myMultiModal']")));
        launchModal2.click();
        WebElement secondModalBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-target='#mySecondModal']")));
        secondModalBtn.click();
        WebElement saveChanges2 = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='mySecondModal']//*[text()='Save Changes']")));
        saveChanges2.click();

        driver.navigate().back();








        driver.navigate().back();

        driver.close();





















    }
}
