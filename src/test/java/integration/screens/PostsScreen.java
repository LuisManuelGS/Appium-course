package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.elements.interfaces.ITextBox;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class PostsScreen extends Screen {

    private final ILabel postFour = AqualityServices.getElementFactory().getLabel(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"][1]/android.widget.LinearLayout[2]"),"post 4th");
    private final ILabel postOne = AqualityServices.getElementFactory().getLabel(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"]/android.widget.LinearLayout[1]"),"post 1");
    private final ILabel searchField = AqualityServices.getElementFactory().getLabel(By.id("org.joinmastodon.android:id/search_text"),"Search field");
    private final ITextBox search = AqualityServices.getElementFactory().getTextBox(By.xpath("//android.widget.EditText[@text=\"Search Mastodon\"]"),"Search");
    private final ILabel userProfile = AqualityServices.getElementFactory().getLabel(AppiumBy.androidUIAutomator("new UiSelector().text(\"Go to @Supervet@mastodon.social\")"),"Go to user");
    private final ILabel goToUserProfile = AqualityServices.getElementFactory().getLabel(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"]/android.widget.LinearLayout[1]"),"Go to user");
    private final ILabel back = AqualityServices.getElementFactory().getLabel(By.xpath("//android.view.ViewGroup[@resource-id=\"org.joinmastodon.android:id/toolbar\"]/android.widget.ImageButton"),"back label");
    private final ILabel tabHome = AqualityServices.getElementFactory().getLabel(By.id("org.joinmastodon.android:id/tab_home"),"tab home");

    public PostsScreen() {
        super(By.xpath("//android.widget.LinearLayout[@content-desc=\"Posts\"]"), "Posts");
    }

    public void clickPost4(){
        postFour.click();
    }

    public void clickPost1(){
        postOne.click();
    }

    public void clickSearchField(){
        searchField.click();
    }

    public void searchUser(String text) {
        search.clearAndType(text);
    }

    public boolean isUserProfileDisplayedOnSearchResults() {
        return userProfile.state().waitForDisplayed();
    }

    public void clickGoToUserProfile(){
        goToUserProfile.click();
    }

    public void clickBack(){
        back.click();
    }
    public void clickTabHome(){
        tabHome.click();
    }

}
