package corp.king.booksapp.presentation.presenters.interfaces;

import android.view.View;

public interface IStartPresenter {
    interface OnClickListener {
        void onGetStartedClicked(View view);
        void onRegistrationClicked(View view);
    }
    OnClickListener getListener();
}
