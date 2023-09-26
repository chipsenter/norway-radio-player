import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestPage {


    // region Page Objects
    LoginPage loginPage = page(LoginPage.class);
    SelenideElement acceptCookies = $(By.id("onetrust-accept-btn-handler"));
    SelenideElement cancelModal = $(By.xpath("//button[contains(text(),'Nei takk, senere')]"));
    SelenideElement playButton = $$(By.className("main-player-button")).get(1);

    // endregion
    @Test(enabled = false)
    public void loginFlow() {
        Configuration.holdBrowserOpen = true;
        loginPage.openTestPage();
    }

    @Test
    public void playRadio() {
        /**
         * Radio channel 0 = Nrj
         * Radio channel 1 = P4
         * Radio channel 2 = P5 Hits
         * Radio channel 3 = Rock
         * Radio channel 4 = Klem
         * Radio channel 5 = Pop
         * Radio channel 6 = Retro
         * Radio channel 7 = Country
         * Radio channel 8 = Bandit
         * Radio channel 9 = NonStop Hits
         */
        Configuration.holdBrowserOpen = true;
        loginPage.openRadio();
        acceptCookies.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        cancelModal.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        loginPage.selectRadio(1);
        playButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        minimizeWindow(true);
    }


    // region Private Methods
    private void minimizeWindow(boolean minimize) {
        sleep(10000);
        if (minimize) {
            getWebDriver().manage().window().minimize();
        }
    }
    // endregion
}
