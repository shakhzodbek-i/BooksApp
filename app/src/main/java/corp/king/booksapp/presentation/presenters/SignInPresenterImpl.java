package corp.king.booksapp.presentation.presenters;

import com.google.firebase.auth.FirebaseAuth;

import corp.king.booksapp.presentation.presenters.interfaces.ISignInPresenter;
import corp.king.booksapp.presentation.views.interfaces.ISignInView;

public class SignInPresenterImpl implements ISignInPresenter {
    private FirebaseAuth mAuth;
    private ISignInView mView;

    public SignInPresenterImpl(ISignInView view) {
        this.mAuth = FirebaseAuth.getInstance();
        this.mView = view;
    }

    @Override
    public void forgetPassword(String email) {

    }

    @Override
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                mView.hideProgress();
                mView.navigateToMainPage();
            }else{
                mView.showError(task.getException().getMessage());

            }
        });
    }
}
