package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class PostOpened extends Screen {

    private final ILabel back = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]"), "back");
    private final ILabel myReplayedPost = AqualityServices.getElementFactory().getLabel(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"]/android.widget.LinearLayout[4]"),"My replayed post");

    public PostOpened() {
        super(By.id("org.joinmastodon.android:id/toolbar"), "toolbar");
    }

        public void backClick() {
        back.click();
    }

    public boolean isReplayedPostDisplayed() {
        return myReplayedPost.state().waitForDisplayed();
    }

}
