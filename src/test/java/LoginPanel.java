import Base.BaseTest;
import Pages.HomePage;
import Pages.RegisterPage;
import io.qameta.allure.Feature;
import org.testng.annotations.*;



@Feature("lOGİN TEST SENARYOLARI")
public class LoginPanel extends BaseTest {


    @Test(description = "Giriş aşaması")
    public void TC0001(){
        HomePage homePage = new HomePage(driver);
        homePage
                .UserNameDoldur("Test")
                .PasswordDoldur("Test123456")
                .Login();
        takeScreenshot(driver);


    }
    @Test(description = "Kayıt sayfası kontrol")
    public void TC0002(){
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage
                .ClickTikla()
                .RegisterKontrol("Signing up is easy!");
        takeScreenshot(driver);
    }
    @Test(description = "Başarısız giriş durumu")
    public void TC0003(){
        HomePage homePage = new HomePage(driver);
        homePage
                .UserNameDoldur("Test")
                .PasswordDoldur("")
                .Login()
                .LoginKontrol("Please enter a username and password.");
    }



}
