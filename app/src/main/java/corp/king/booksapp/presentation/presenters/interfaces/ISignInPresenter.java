package corp.king.booksapp.presentation.presenters.interfaces;

public interface ISignInPresenter {
    void forgetPassword(String email);

    void signIn(String email, String password);
}
