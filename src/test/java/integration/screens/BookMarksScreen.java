package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import org.openqa.selenium.By;

public class BookMarksScreen extends Screen {

    private final ILabel bookmarkPost = AqualityServices.getElementFactory().getLabel(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"]/android.widget.LinearLayout[1]"),"bookmark post");
    private final ILabel back = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.ImageButton[@content-desc=\"Back\"]"), "back");

    public BookMarksScreen() {
        super(By.id("org.joinmastodon.android:id/toolbar"), "BookMarks toolbar");
    }

    public boolean isBookmarkPostVisible() {
        return bookmarkPost.state().waitForDisplayed();
    }

    public void clickBack() {
        back.click();
    }
}
