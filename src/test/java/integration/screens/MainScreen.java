package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.IRadioButton;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class MainScreen extends Screen {

    private final IButton loginBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_log_in"),"Login");
    private final IRadioButton serverName = AqualityServices.getElementFactory().getRadioButton(By.xpath("(//android.widget.RadioButton[@resource-id=\"org.joinmastodon.android:id/radiobtn\"])[1]"),"server name");
    private final IButton nextBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/btn_next"),"Next Btn");
    private final IButton authorizeButton = AqualityServices.getElementFactory().getButton(By.xpath("//android.widget.Button[@text=\"Authorize\"]"),"Authorize");


    public MainScreen() {
        super(By.id("org.joinmastodon.android:id/btn_log_in"), "Login element");
    }

    public void loginBtnClick() {
        loginBtn.click();
    }

    public void serverNameClick() {
        serverName.click();
    }

    public void nextBtnClick() {
        nextBtn.click();
    }

    public void authorizeBtnClick() {
        authorizeButton.click();
    }

}
