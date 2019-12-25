package thachpham.hometest.homepanel.category;

import thachpham.hometest.homepanel.HomePanelAdapter;
import thachpham.hometest.homepanel.HomePanelFragment;
import thachpham.hometest.homepanel.HomePanelViewModel;

public class CategoryFragment extends HomePanelFragment {

    @Override
    protected Class<? extends HomePanelViewModel> getViewModelClassType() {
        return CategoryViewModel.class;
    }
}
