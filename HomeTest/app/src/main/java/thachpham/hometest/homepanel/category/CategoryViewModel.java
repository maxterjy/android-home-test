package thachpham.hometest.homepanel.category;

import thachpham.hometest.homepanel.HomePanelViewModel;

public class CategoryViewModel extends HomePanelViewModel {
    @Override
    protected String getDataUrl() {
        return "https://raw.githubusercontent.com/maxterjy/android-home-test/master/online-data/category.json";
    }
}
