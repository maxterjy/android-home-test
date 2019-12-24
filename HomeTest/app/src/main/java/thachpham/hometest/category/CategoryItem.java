package thachpham.hometest.category;

public class CategoryItem {
    String mTitle;
    String mImageUrl;

    public CategoryItem(String title, String imageUrl) {
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
