package thachpham.hometest.homepanel.shortcut;

import thachpham.hometest.homepanel.HomePanelViewModel;

public class ShortcutViewModel extends HomePanelViewModel {
    @Override
    protected String getDataUrl() {
        return "https://raw.githubusercontent.com/maxterjy/android-home-test/master/online-data/shortcut.json";
    }
}
