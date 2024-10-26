package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SupervetProfileScreen extends Screen {

    private final IButton followBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/profile_action_btn"),"follow button");
    private final ILabel followersCount = AqualityServices.getElementFactory().getLabel(By.id("org.joinmastodon.android:id/followers_count"),"followers count");
    private final ILabel back = AqualityServices.getElementFactory().getLabel(AppiumBy.androidUIAutomator("new UiSelector().description(\"Back\")"), "back");

    public SupervetProfileScreen() {
        super(AppiumBy.androidUIAutomator("new UiSelector().text(\"Supervet\").instance(0)"), "Supervet");
    }

    public void clickFollowButton() {
        followBtn.click();
    }

    public String getFollowersCount() {
        return followersCount.getText();
    }
    public void clickBack() {
        back.click();
    }

}
