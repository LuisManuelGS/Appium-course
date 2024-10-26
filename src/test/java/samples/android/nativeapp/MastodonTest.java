package samples.android.nativeapp;

import aquality.appium.mobile.application.AqualityServices;
import integration.screens.*;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Context;
import utils.Scroll;
import java.sql.SQLException;
import java.util.UUID;

public class MastodonTest extends BaseTest {

    MainScreen mainScreen = new MainScreen();
    HomeScreen homeScreen = new HomeScreen();
    PostsScreen postsScreen = new PostsScreen();
    PostOpened postOpened = new PostOpened();
    NewPostScreen newPostScreen = new NewPostScreen();
    ProfileScreen profileScreen = new ProfileScreen();
    SupervetProfileScreen supervetProfileScreen = new SupervetProfileScreen();
    BookMarksScreen bookMarksScreen = new BookMarksScreen();

    private final String RANDOM_TEXT = UUID.randomUUID().toString();
    private final String RANDOM_TEXT2 = UUID.randomUUID().toString();
    private final String LIKED = "1";
    private final String USER = "@Supervet";

    @Test
    public void test() throws InterruptedException, SQLException {

        mainScreen.loginBtnClick();
        mainScreen.serverNameClick();
        mainScreen.nextBtnClick();
        mainScreen.authorizeBtnClick();
        Thread.sleep(5000);
        Alert alert = AqualityServices.getApplication().getDriver().switchTo().alert();
        alert.dismiss();
        Thread.sleep(1000);
        Assert.assertTrue(homeScreen.state().isDisplayed(),"Home screen is not displayed");
        homeScreen.clickExploreTab();
        Assert.assertTrue(postsScreen.state().isDisplayed(),"Posts screen is not displayed");
        Thread.sleep(5000);
        Scroll.scrollDown();
        postsScreen.clickPost4();
        Assert.assertTrue(postOpened.state().isDisplayed(),"Posts fourth screen is not displayed");
        postOpened.backClick();
        Thread.sleep(5000);
        Scroll.scrollUp();
        Thread.sleep(3000);
        postsScreen.clickPost1();
        Assert.assertTrue(postOpened.state().waitForDisplayed(),"Posts One screen is not displayed");
    }

    @Test
    public void test2() throws InterruptedException {
        mainScreen.loginBtnClick();
        mainScreen.serverNameClick();
        mainScreen.nextBtnClick();
        mainScreen.authorizeBtnClick();
        Thread.sleep(5000);
        Alert alert = AqualityServices.getApplication().getDriver().switchTo().alert();
        alert.dismiss();
        Assert.assertTrue(homeScreen.state().isDisplayed(),"Home screen is not displayed");
        homeScreen.clickExploreTab();
        Assert.assertTrue(postsScreen.state().isDisplayed(),"Posts screen is not displayed");
        Context.contexts();
    }

    @Test
    public void test3() throws InterruptedException {
        mainScreen.loginBtnClick();
        mainScreen.serverNameClick();
        mainScreen.nextBtnClick();
        mainScreen.authorizeBtnClick();
        Thread.sleep(5000);
        Alert alert = AqualityServices.getApplication().getDriver().switchTo().alert();
        alert.dismiss();
        Thread.sleep(3000);
        Assert.assertTrue(homeScreen.state().isDisplayed(),"Home screen is not displayed");
        homeScreen.clickComposeButton();
        newPostScreen.inputText(RANDOM_TEXT);
        newPostScreen.publishNewPost();
        homeScreen.clickProfileTab();
        Assert.assertTrue(profileScreen.isPostDisplayed(),"Post is not displayed");
        profileScreen.clickLikeButton();
        Assert.assertEquals(profileScreen.postLiked(), LIKED,"Post is not liked");
        profileScreen.clickReplayButton();
        newPostScreen.inputText(RANDOM_TEXT2);
        newPostScreen.publishNewPost();
        profileScreen.clickFirstPost();
        Assert.assertTrue(postOpened.isReplayedPostDisplayed(),"Replayed post is not displayed");
        postOpened.backClick();
        profileScreen.clickDeletePost();
        Assert.assertFalse(profileScreen.isFirstPostDisplayed(),"Post is displayed");
        homeScreen.clickExploreTab();
        postsScreen.clickSearchField();
        postsScreen.searchUser(USER);
        Assert.assertTrue(postsScreen.isUserProfileDisplayedOnSearchResults(),"User is not displayed");
        postsScreen.clickGoToUserProfile();
        supervetProfileScreen.clickFollowButton();
        supervetProfileScreen.clickBack();
        postsScreen.clickGoToUserProfile();
        final String SUPERVET_FOLLOWERS = supervetProfileScreen.getFollowersCount();
        Assert.assertEquals(supervetProfileScreen.getFollowersCount(), SUPERVET_FOLLOWERS, "Followers have not increased");
        supervetProfileScreen.clickBack();
        postsScreen.clickBack();
        Thread.sleep(3000);
        postsScreen.clickTabHome();
        homeScreen.clickReplayPostBtn();
        newPostScreen.publishNewPost();
        homeScreen.clickProfileTab();
        profileScreen.clickOnPostAndReplies();
        Assert.assertTrue(profileScreen.isPostDisplayed(),"Replayed Post is not displayed");
        profileScreen.bookmarkPost();
        profileScreen.bookmarksPosts();
        Assert.assertTrue(bookMarksScreen.isBookmarkPostVisible(), "Bookmark post is not displayed");
        bookMarksScreen.clickBack();
        profileScreen.clickExploreTab();
        postsScreen.clickSearchField();
        postsScreen.searchUser(USER);
        postsScreen.clickGoToUserProfile();
        supervetProfileScreen.clickFollowButton();
        supervetProfileScreen.clickBack();
        postsScreen.clickGoToUserProfile();
        final String FOLLOWERS = supervetProfileScreen.getFollowersCount();
        Assert.assertEquals(supervetProfileScreen.getFollowersCount(), FOLLOWERS, "Followers have not decremented");
        supervetProfileScreen.clickBack();
        postsScreen.clickBack();
        postsScreen.clickTabHome();
        homeScreen.logOut();
        Assert.assertTrue(mainScreen.state().waitForDisplayed(),"login screen is not displayed");
    }

}
