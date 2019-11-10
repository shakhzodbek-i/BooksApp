package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import corp.king.booksapp.R;

public class WelcomeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent= new Intent(WelcomeActivity.this, StartActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}