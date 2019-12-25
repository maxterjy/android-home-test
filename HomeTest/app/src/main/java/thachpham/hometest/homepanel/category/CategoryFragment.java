package thachpham.hometest.homepanel.category;

import android.graphics.Color;

import thachpham.hometest.R;
import thachpham.hometest.homepanel.HomePanelAdapter;
import thachpham.hometest.homepanel.HomePanelFragment;
import thachpham.hometest.homepanel.HomePanelUIData;
import thachpham.hometest.homepanel.HomePanelViewModel;

public class CategoryFragment extends HomePanelFragment {

    @Override
    protected Class<? extends HomePanelViewModel> getViewModelClassType() {
        return CategoryViewModel.class;
    }

    @Override
    protected HomePanelUIData getUIData() {
        return new HomePanelUIData(getResources().getString(R.string.title_category), 2);
    }
}
