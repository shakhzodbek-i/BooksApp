package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

import corp.king.booksapp.R;

public class ProfileActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editText;
    private Button btn_save;
    private static final int CHOOSE_IMAGE=101;
    private Uri uriProfileImage;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private String profileImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prifile);


        imageView=findViewById(R.id.profile_img);
        editText=findViewById(R.id.editTextDisplaName);
        btn_save=findViewById(R.id.save_btn);
        progressBar=findViewById(R.id.progressbar_forimg);
        mAuth=FirebaseAuth.getInstance();

        imageView.setOnClickListener(view -> showImageChooser());
        btn_save.setOnClickListener(view -> saveUserInformation());

    }


    private void saveUserInformation() {
      String displayName=editText.getText().toString();

      if(displayName.isEmpty()){
          editText.setError("Name required");
          editText.requestFocus();
          return;
      }
        FirebaseUser user= mAuth.getCurrentUser();

      if(user!=null){
          UserProfileChangeRequest profile =new UserProfileChangeRequest.Builder().setDisplayName(displayName).setPhotoUri(Uri.parse(profileImageUrl))
                  .build();
          user.updateProfile(profile).addOnCompleteListener(task -> {
              if(task.isSuccessful()){
                  Toast.makeText(ProfileActivity.this, "Profile Updated", Toast.LENGTH_SHORT).show();

              }
          });
      }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==CHOOSE_IMAGE && resultCode==RESULT_OK && data !=null && data.getData()!=null){
           uriProfileImage= data.getData();
            try {
                Bitmap bitmap= MediaStore.Images.Media.getBitmap(getContentResolver(), uriProfileImage);
           imageView.setImageBitmap(bitmap);

             uploadImageToFirebaseStorage();

                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    private void uploadImageToFirebaseStorage() {
        btn_save.setEnabled(false);
        StorageReference profileImage=FirebaseStorage.getInstance().getReference("profilepics/"+System.currentTimeMillis()+"jpg");
        if(uriProfileImage!=null){
            progressBar.setVisibility(View.VISIBLE);
            profileImage.putFile(uriProfileImage).addOnSuccessListener(taskSnapshot -> {
                progressBar.setVisibility(View.GONE);
                profileImageUrl= profileImage.getDownloadUrl().toString();

            btn_save.setEnabled(true);
            })
                    .addOnFailureListener(e -> {
                        progressBar.setVisibility(View.GONE);
                        btn_save.setEnabled(true);
                        Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    });

        }
    }


    private  void showImageChooser(){
        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select profile image"), CHOOSE_IMAGE);
    }
}
