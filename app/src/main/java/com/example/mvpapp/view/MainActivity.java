package com.example.mvpapp.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mvpapp.R;
import com.example.mvpapp.presenter.ILoginPresenter;
import com.example.mvpapp.presenter.LoginPresenterImpl;

public class MainActivity extends AppCompatActivity implements ILoginView{
    EditText email, password;
    ProgressBar progressBar;
    Button loginBtn;

    private ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);
        progressBar = findViewById(R.id.progressBar);
        loginBtn = findViewById(R.id.button);

        loginPresenter = new LoginPresenterImpl(this);
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.setProgressBarVisibility(View.VISIBLE);
                loginPresenter.doLogin(email.getText().toString().trim(),
                        password.getText().toString().trim());
            }
        });

        }

    @Override
    public void onLoginSuccess(String msg) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String msg) {
        loginPresenter.setProgressBarVisibility(View.INVISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetProgressBarVisibility(int visibility) {
        progressBar.setVisibility(visibility);
    }
}
