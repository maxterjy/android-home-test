package thachpham.hometest.homepanel.utility;

import thachpham.hometest.homepanel.HomePanelViewModel;

public class UtilityViewModel extends HomePanelViewModel {
    @Override
    protected String getDataUrl() {
        return "https://raw.githubusercontent.com/maxterjy/android-home-test/master/online-data/utility.json";
    }
}
