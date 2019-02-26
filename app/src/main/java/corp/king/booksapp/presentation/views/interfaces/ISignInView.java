package corp.king.booksapp.presentation.views.interfaces;

public interface ISignInView {
    void navigateToMainPage();

    void showProgress();

    void hideProgress();

    void showError(String msg);
}
