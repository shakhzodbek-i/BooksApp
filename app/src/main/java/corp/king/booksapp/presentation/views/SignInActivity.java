package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import corp.king.booksapp.R;
import corp.king.booksapp.presentation.presenters.SignInPresenterImpl;
import corp.king.booksapp.presentation.presenters.interfaces.ISignInPresenter;
import corp.king.booksapp.presentation.views.interfaces.ISignInView;

public class SignInActivity extends AppCompatActivity implements ISignInView {

   private Button signIn;
   private EditText email;
   private EditText password;
   private ProgressBar progressBar;
    private ISignInPresenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        initView();

        mPresenter = new SignInPresenterImpl(this);

        signIn.setOnClickListener(view -> {

             String email= this.email.getText().toString().trim();
             String password= this.password.getText().toString().trim();

            if(email.isEmpty()){
                this.email.setError("Email is required");
                this.email.requestFocus();
                return;
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                this.email.setError("Please enter a valid email");
                this.email.requestFocus();
                return;
            }

            if(password.length()<6){
                this.password.setError("Minimum length of password should be 6");
                this.password.requestFocus();
                return;
            }

            if(password.isEmpty()){
                this.password.setError("Password is required");
                this.password.requestFocus();
                return;
            }
            showProgress();
            mPresenter.signIn(email, password);
                    });
    }

    private void initView() {
        signIn= findViewById(R.id.sign_in);
        email = findViewById(R.id.login);
        password= findViewById(R.id.password);
        progressBar= findViewById(R.id.prog_bar);
    }

    @Override
    public void navigateToMainPage() {
        Intent intent=new Intent(SignInActivity.this, MainActivity.class );
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
