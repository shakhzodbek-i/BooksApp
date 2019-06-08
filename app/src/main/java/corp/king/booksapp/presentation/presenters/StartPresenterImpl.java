package corp.king.booksapp.presentation.presenters;

import android.view.View;

import corp.king.booksapp.presentation.listeners.StartPageListener;
import corp.king.booksapp.presentation.presenters.interfaces.StartPresenter;
import corp.king.booksapp.presentation.views.interfaces.IStartView;

public class StartPresenterImpl implements StartPresenter, StartPageListener {

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
