package com.example.mvpapp.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.mvpapp.model.IUser;
import com.example.mvpapp.model.UserImpl;
import com.example.mvpapp.view.ILoginView;

public class LoginPresenterImpl implements ILoginPresenter{

    private ILoginView loginView;
    private Handler handler;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void doLogin(String email, String password) {
        IUser user = new UserImpl(email, password);
        int loginCode = user.checkUserValidity();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (loginCode == 0)
                {
                    loginView.onLoginError("Please Enter Your Email");
                }
                else if (loginCode == 1)
                {
                    loginView.onLoginError("Please Enter a Valid Mail");
                } else if (loginCode == 2)
                {
                    loginView.onLoginError("Please Enter Password");
                } else if (loginCode == 3)
                {
                    loginView.onLoginError("Password Must be 6 Character");
                }
                else
                {
                    loginView.onLoginSuccess("Login Successful");
                }
            }
        },2000);

    }

    @Override
    public void setProgressBarVisibility(int visibility) {
        loginView.onSetProgressBarVisibility(visibility);
    }
}
