package pages;

import Utilities.Constant;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public SelenideElement username = null;
    public SelenideElement password = null;
    ElementsCollection radioChannels = $$(By.className("channel-logo"));

    public void openTestPage() {
        open(Constant.selctorsTrainingPage);
    }
    public void openRadio() {
        open(Constant.P4);
    }

    public void selectRadio(int radioChannel) {
        sleep(2000);
        System.out.println("Let's play some radio!");
        radioChannels.get(radioChannel).scrollIntoView(true);
        sleep(1000);
        radioChannels.get(radioChannel).hover();
        sleep(1000);
        radioChannels.get(radioChannel).click();
        sleep(5000);
    }
}
