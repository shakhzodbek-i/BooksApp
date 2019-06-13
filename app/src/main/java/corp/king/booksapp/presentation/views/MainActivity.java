package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import corp.king.booksapp.R;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.user_name);
        imageView=findViewById(R.id.profile_image);
        loadUserInformation();

    }

    private void loadUserInformation() {
        FirebaseUser user=mAuth.getCurrentUser();

        if(user.getPhotoUrl()!=null){
            Glide.with(this).load(user.getPhotoUrl().toString()).into(imageView);

        }
        if(user.getDisplayName()!=null) {
            editText.setText(user.getDisplayName());

        }
    }
}