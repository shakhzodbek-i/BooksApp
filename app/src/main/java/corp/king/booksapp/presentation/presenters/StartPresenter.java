package corp.king.booksapp.presentation.presenters;

import android.view.View;

import corp.king.booksapp.presentation.presenters.interfaces.IStartPresenter;
import corp.king.booksapp.presentation.views.interfaces.IStartView;

public class StartPresenter implements IStartPresenter {

    private IStartView mView;

    private IStartPresenter.OnClickListener listener = new OnClickListener() {
        @Override
        public void onGetStartedClicked(View view) {
        }

        @Override
        public void onRegistrationClicked(View view) {
            mView.navigateToRegistrationActivity();
        }
    };

    public StartPresenter(IStartView mView) {
        this.mView = mView;
    }

    @Override
    public OnClickListener getListener() {
        return listener;
    }
}
