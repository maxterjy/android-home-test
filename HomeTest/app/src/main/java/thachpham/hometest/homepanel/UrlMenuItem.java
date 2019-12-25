package thachpham.hometest.homepanel;

public class UrlMenuItem {
    String mTitle;
    String mImageUrl;

    public UrlMenuItem(String title, String imageUrl) {
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
