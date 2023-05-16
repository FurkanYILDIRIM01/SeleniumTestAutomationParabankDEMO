package Pages;

import Base.BaseLib;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage extends BaseLib {
    private WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver =driver;

    }
    @Step("register alanına tıklanır")
    public RegisterPage ClickTikla(){
        driver.findElement(By.cssSelector("#loginPanel > p:nth-child(3) > a")).click();
        takeScreenshot(driver);
        return this;
   }
    @Step("register sayfası text kontrol")
    public RegisterPage RegisterKontrol(String text) {
        String RegisterKontrolTitle= driver.findElement(By.cssSelector("#rightPanel > h1")).getText();
        Allure.addAttachment(text+ "metnin geldiği görülmüştür","");
        Assert.assertEquals(RegisterKontrolTitle,text);
        return this;
    }
}
