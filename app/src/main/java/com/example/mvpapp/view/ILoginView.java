package com.example.mvpapp.view;

public interface ILoginView {
    void onLoginSuccess(String msg);
    void onLoginError(String msg);
    void onSetProgressBarVisibility(int visibility);
}
