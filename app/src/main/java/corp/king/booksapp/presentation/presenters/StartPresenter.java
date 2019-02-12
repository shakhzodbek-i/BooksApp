package corp.king.booksapp.presentation.presenters;

import android.view.View;

import corp.king.booksapp.presentation.presenters.interfaces.IStartPresenter;
import corp.king.booksapp.presentation.views.interfaces.IStartView;

public class StartPresenter implements IStartPresenter, IStartPresenter.OnClickListener {

    private IStartView mView;

    public StartPresenter(IStartView mView) {
        this.mView = mView;
    }

    @Override
    public void onGetStartedClicked(View view) {
    }

    @Override
    public void onRegistrationClicked(View view) {
        mView.navigateToRegistrationActivity();
    }
}
