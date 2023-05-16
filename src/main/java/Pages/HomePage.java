package Pages;

import Base.BaseLib;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseLib {
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver =driver;

    }
    @Step("username alanı doldurulur")
    public HomePage UserNameDoldur(String text){
        driver.findElement(By.name("username")).sendKeys(text);
        takeScreenshot(driver);
        return this;
    }
    @Step("password alanı doldurulur")
    public HomePage PasswordDoldur(String pass){
        driver.findElement(By.name("password")).sendKeys(pass);
        return this;
    }
    @Step("login butonuna tıklanır")
    public HomePage Login(){
        driver.findElement(By.cssSelector("#loginPanel > form > div:nth-child(5) > input")).click();
        return this;
    }
    @Step("login error text kontrol")
    public HomePage LoginKontrol(String text) {
        String LoginKontrolErrorText= driver.findElement(By.cssSelector("#rightPanel > p")).getText();
        Assert.assertEquals(LoginKontrolErrorText,text);
        return this;
    }



}
