package corp.king.booksapp.presentation.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;

import corp.king.booksapp.R;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener {
    private Button signOut;
    private SignInButton signIn;
    private TextView name, email, client_code;
    private ImageView prof_Pic;
    private ConstraintLayout profile_sec;
    private GoogleApiClient googleApiClient;
    private static final int REQ_CODE=9001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();


        signOut.setOnClickListener(this);
        signIn.setOnClickListener(this);

        profile_sec.setVisibility(View.GONE);
        String serverClientId = getString(R.string.server_client_id);
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope(Scopes.DRIVE_APPFOLDER))
                .requestServerAuthCode(serverClientId)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions)
                .build();
    }



    private void initView() {
        profile_sec = findViewById(R.id.Constraint);
        signOut = findViewById(R.id.btn_logout);
        signIn = findViewById(R.id.google_log_in);
        name = findViewById(R.id.username);
        email = findViewById(R.id.useremail);
        client_code = findViewById(R.id.client_code);
        prof_Pic = findViewById(R.id.prif_pic);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.google_log_in:
            signIn();

            break;

        case R.id.btn_logout:
            signOut();
            break;
    }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(SignInActivity.this, "Connection Failed!", Toast.LENGTH_SHORT).show();

    }


    private void signIn(){
        Intent intent =Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(intent,REQ_CODE);
    }

    private void signOut(){

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                updateUI(false);
            }
        });

    }

    @SuppressLint("StringFormatInvalid")
    private void handleResult(GoogleSignInResult result){
        if(result.isSuccess()){

            GoogleSignInAccount account = result.getSignInAccount();
                String authCode=account.getServerAuthCode();
                String this_name=account.getDisplayName();
            String this_email=account.getEmail();
            Uri img_url=account.getPhotoUrl();
            name.setText(this_name);
            email.setText(this_email);
            client_code.setText(getString(R.string.server_client_id,authCode));
            Glide.with(this).load(img_url).fitCenter().placeholder(R.drawable.ic_user).into(prof_Pic) ;
            updateUI(true);

            Intent intent =new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);

        }
        else{
            updateUI(false);
        }

    }

    private void updateUI(boolean idLogin){
        if(idLogin){
            profile_sec.setVisibility(View.VISIBLE);
            signIn.setVisibility(View.GONE);
        }
        else{
            profile_sec.setVisibility(View.GONE);
            signIn.setVisibility(View.VISIBLE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQ_CODE){
            GoogleSignInResult result= Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
            }

        else {
            Toast.makeText(SignInActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
        }
    }

}