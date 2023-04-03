import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.example.HomePage;
import com.qaprosoft.carina.demo.example.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest implements IAbstractTest {

    @Test
    public void testRegistrationPage(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        RegistrationPage regPage = homePage.clickSignUpButton();
        regPage.typeData("Ivan", "Ivanov");
        Assert.assertEquals(regPage.getCurrentUrl(),"https://www.facebook.com/");

    }
}
