package thachpham.hometest.homepanel;

public class HomeMenuItem {
    String mTitle;
    String mImageUrl;

    public HomeMenuItem(String title, String imageUrl) {
        mTitle = title;
        mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}
