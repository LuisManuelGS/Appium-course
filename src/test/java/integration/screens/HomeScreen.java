package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomeScreen extends Screen {

    private final ILabel exploreTab = AqualityServices.getElementFactory().getLabel(By.id("org.joinmastodon.android:id/tab_search"),"explorer tab");
    private final IButton composeButton = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/fab"),"Compose Post");
    private final ILabel profileTab = AqualityServices.getElementFactory().getLabel(By.id("org.joinmastodon.android:id/tab_profile"),"profile tab");
    private final IButton replayPostBtn = AqualityServices.getElementFactory().getButton(By.xpath("(//android.widget.TextView[@resource-id=\"org.joinmastodon.android:id/reply\"])[2]"),"replay post");
    private final IButton settingsBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/settings"),"settings");
    private final ILabel logOut = AqualityServices.getElementFactory().getLabel(AppiumBy.androidUIAutomator("new UiSelector().text(\"Log out\")"),"log out");
    private final IButton logOutBtn = AqualityServices.getElementFactory().getButton(By.id("android:id/button1"),"log out button");

    public HomeScreen() {
        super(By.xpath("(//android.widget.TextView[@text=\"Home\"])[1]"), "Home");
    }

    public void clickExploreTab() {
        exploreTab.click();
    }

    public void clickComposeButton() {
        composeButton.click();
    }

    public void clickProfileTab() {
        profileTab.click();
    }

    public void clickReplayPostBtn() {
        replayPostBtn.click();
    }

    public void logOut() {
        settingsBtn.click();
        logOut.click();
        logOutBtn.click();
    }
}
