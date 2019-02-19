package corp.king.booksapp.presentation.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import corp.king.booksapp.R;
import corp.king.booksapp.databinding.ActivityStartBinding;
import corp.king.booksapp.presentation.presenters.StartPresenter;
import corp.king.booksapp.presentation.presenters.interfaces.IStartPresenter;
import corp.king.booksapp.presentation.views.interfaces.IStartView;

public class StartActivity extends AppCompatActivity implements IStartView {

    private ActivityStartBinding binding;
    private IStartPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_start);
        presenter = new StartPresenter(this);
        binding.setListener(presenter.getListener());
    }

    @Override
    public void navigateToRegistrationActivity() {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}