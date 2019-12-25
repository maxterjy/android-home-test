package thachpham.hometest.homepanel.shortcut;

import thachpham.hometest.homepanel.HomePanelFragment;
import thachpham.hometest.homepanel.HomePanelUIData;
import thachpham.hometest.homepanel.HomePanelViewModel;

public class ShortcutFragment extends HomePanelFragment {
    @Override
    protected Class<? extends HomePanelViewModel> getViewModelClassType() {
        return ShortcutViewModel.class;
    }

    @Override
    protected HomePanelUIData getUIData() {
        return new HomePanelUIData("Tính năng mới", 1);
    }
}
