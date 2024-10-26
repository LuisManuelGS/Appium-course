package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NewPostScreen extends Screen {

    private final ITextBox textBox = AqualityServices.getElementFactory().getTextBox(By.id("org.joinmastodon.android:id/toot_text"),"Text Box");
    private final IButton publish = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/publish"),"Publish");

    public NewPostScreen() {
        super(AppiumBy.androidUIAutomator("new UiSelector().text(\"New post\")"), "New Post");
    }

    public void inputText(String text) {
        textBox.clearAndType(text);
    }

    public void publishNewPost() {
        publish.click();
    }

}
