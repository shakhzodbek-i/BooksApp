package corp.king.booksapp.presentation.presenters;

import android.view.View;

import corp.king.booksapp.presentation.callbacks.StartCallback;
import corp.king.booksapp.presentation.presenters.interfaces.IStartPresenter;
import corp.king.booksapp.presentation.views.interfaces.IStartView;

public class StartPresenterImpl implements IStartPresenter, StartCallback {

    private IStartView mView;

    public StartPresenterImpl(IStartView mView) {
        this.mView = mView;
    }

    @Override
    public void onGetStartedClicked(View view) {mView.navigateToSignInActivity();
    }

    @Override
    public void onRegistrationClicked(View view) {
        mView.navigateToRegistrationActivity();
    }
}
