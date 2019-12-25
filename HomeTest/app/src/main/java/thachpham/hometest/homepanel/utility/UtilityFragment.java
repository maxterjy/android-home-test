package thachpham.hometest.homepanel.utility;

import thachpham.hometest.homepanel.HomePanelFragment;
import thachpham.hometest.homepanel.HomePanelViewModel;

public class UtilityFragment extends HomePanelFragment {
    @Override
    protected Class<? extends HomePanelViewModel> getViewModelClassType() {
        return UtilityViewModel.class;
    }
}
