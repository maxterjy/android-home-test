package thachpham.hometest.homepanel.utility;

import android.graphics.Color;

import thachpham.hometest.R;
import thachpham.hometest.homepanel.HomePanelFragment;
import thachpham.hometest.homepanel.HomePanelUIData;
import thachpham.hometest.homepanel.HomePanelViewModel;

public class UtilityFragment extends HomePanelFragment {
    @Override
    protected Class<? extends HomePanelViewModel> getViewModelClassType() {
        return UtilityViewModel.class;
    }

    @Override
    protected HomePanelUIData getUIData() {
        return new HomePanelUIData(getResources().getString(R.string.title_utility), 1);
    }
}
