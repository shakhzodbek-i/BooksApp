package corp.king.booksapp.presentation.presenters.interfaces;

import android.view.View;

import corp.king.booksapp.presentation.callbacks.StartCallback;

public interface IStartPresenter extends StartCallback {
    interface OnClickListener {
        void onGetStartedClicked(View view);
        void onRegistrationClicked(View view);
    }
}
