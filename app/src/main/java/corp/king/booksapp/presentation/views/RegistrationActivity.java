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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.Objects;

import corp.king.booksapp.R;

public class RegistrationActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;
    private EditText password;
    private Button btnRegister;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        mAuth=FirebaseAuth.getInstance();
        username=(EditText) findViewById(R.id.full_name);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        EditText confirmpass = (EditText) findViewById(R.id.confirm_pass);
        btnRegister=(Button)findViewById(R.id.register);
        progressBar=(ProgressBar)findViewById(R.id.progressbar_forimg);


        btnRegister.setOnClickListener(view -> {
           String u_name=username.getText().toString().trim();
           String e_mail=email.getText().toString().trim();
           String pass_word=password.getText().toString().trim();
           String confirm_pass=confirmpass.getText().toString().trim();


           if(u_name.isEmpty()){
               username.setError("Username is required");
               username.requestFocus();
               return;
           }

           if(e_mail.isEmpty()){
               email.setError("Email is required");
               email.requestFocus();
               return;
           }

           if(!Patterns.EMAIL_ADDRESS.matcher(e_mail).matches()){
               email.setError("Please enter a valid email");
               email.requestFocus();
               return;
           }

           if(pass_word.length()<6){
               password.setError("Minimum length of password should be 6");
               password.requestFocus();
               return;
           }

           if(pass_word.isEmpty()){
               password.setError("Password is required");
               password.requestFocus();
               return;
           }


           if(confirm_pass.isEmpty()){
               confirmpass.setError("Confirm Password is required");
               confirmpass.requestFocus();
               return;
           }

            if(!confirm_pass.equals(pass_word)) {
                confirmpass.setError("Passwords are not matched");
                confirmpass.requestFocus();
                return;
            }


          progressBar.setVisibility(View.VISIBLE);


             mAuth.createUserWithEmailAndPassword(e_mail,pass_word).addOnCompleteListener(task -> {
                 progressBar.setVisibility(View.GONE);
                 if (task.isSuccessful()) {
                     finish();
                     Intent intent=new Intent(RegistrationActivity.this, ProfileActivity.class );
                     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                     startActivity(intent);
                 } else{
                     if(task.getException() instanceof FirebaseAuthUserCollisionException){
                         Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();

                     }else{
                         Toast.makeText(getApplicationContext(), Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                     }
                 }

             });

        });

     }


    }


