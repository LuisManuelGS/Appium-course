package integration.screens;

import aquality.appium.mobile.application.AqualityServices;
import aquality.appium.mobile.elements.interfaces.IButton;
import aquality.appium.mobile.elements.interfaces.ILabel;
import aquality.appium.mobile.screens.Screen;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ProfileScreen extends Screen {

    private final ILabel post = AqualityServices.getElementFactory().getLabel(By.xpath("(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"])[1]/android.widget.LinearLayout[1]"),"Post");
    private final ILabel firstPost = AqualityServices.getElementFactory().getLabel(By.xpath("(//androidx.recyclerview.widget.RecyclerView[@resource-id=\"org.joinmastodon.android:id/list\"])[1]/android.widget.LinearLayout[3]"),"First Post");
    private final IButton likeButton = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/favorite"),"Like button");
    private final IButton likedBtn = AqualityServices.getElementFactory().getButton(AppiumBy.androidUIAutomator("new UiSelector().text(\"1\")"),"Liked");
    private final IButton replayBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/reply"),"replay btn");
    private final IButton moreOptionsBtn = AqualityServices.getElementFactory().getButton(By.xpath("(//android.widget.ImageView[@content-desc=\"More options\"])[2]"),"More options");
    private final IButton deleteBtn = AqualityServices.getElementFactory().getButton(AppiumBy.androidUIAutomator("new UiSelector().text(\"Delete\")"),"Delete");
    private final IButton deletePostBtn = AqualityServices.getElementFactory().getButton(By.id("android:id/button1"),"Delete Post");
    private final ILabel postsAndReplies = AqualityServices.getElementFactory().getLabel(By.xpath("//android.widget.TextView[@text=\"Posts and replies\"]"),"Posts and replies");
    private final IButton optionsButton = AqualityServices.getElementFactory().getButton(By.xpath("(//android.widget.ImageView[@content-desc=\"More options\"])[1]"),"More options 1");
    private final IButton bookmarkBtn = AqualityServices.getElementFactory().getButton(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"Bookmark\"]"),"Bookmark");
    private final IButton bookmarksBtn = AqualityServices.getElementFactory().getButton(By.id("org.joinmastodon.android:id/bookmarks"),"Bookmarks");
    private final ILabel exploreTab = AqualityServices.getElementFactory().getLabel(By.id("org.joinmastodon.android:id/tab_search"),"tab search");

    public ProfileScreen() {
        super(By.xpath("(//android.widget.TextView[@text=\"Luis Manuel\"])[1]"), "Profile name");
    }

    public boolean isPostDisplayed() {
        return post.state().waitForDisplayed();
    }

    public void clickLikeButton() {
        likeButton.click();
    }

    public String postLiked() {
        return likedBtn.getText();
    }

    public void clickReplayButton() {
        replayBtn.click();
    }

    public void clickFirstPost() {
        firstPost.click();
    }

    public boolean isFirstPostDisplayed() {
        return firstPost.state().isDisplayed();
    }

    public void clickDeletePost() {
        moreOptionsBtn.click();
        deleteBtn.click();
        deletePostBtn.click();
    }

    public void clickOnPostAndReplies() {
        postsAndReplies.click();
    }

    public void bookmarkPost() {
        optionsButton.click();
        bookmarkBtn.click();
    }

    public void bookmarksPosts() {
        bookmarksBtn.click();
    }

    public void clickExploreTab() {
        exploreTab.click();
    }

}
