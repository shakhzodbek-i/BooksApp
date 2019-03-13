package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import corp.king.booksapp.R;

public class SignInActivity extends AppCompatActivity  {

   private Button signIn;
   private EditText email;
   private EditText password;
   private ProgressBar progressBar;
   private FirebaseAuth mAuth;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        FirebaseApp.initializeApp(this);
        mAuth=FirebaseAuth.getInstance();
         initView();


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
          progressBar.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(SignInActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null){
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }

    private void initView() {
        signIn= findViewById(R.id.sign_in);
        email = findViewById(R.id.login);
        password= findViewById(R.id.password);
        progressBar= findViewById(R.id.prog_bar);
    }
}
