package com.example.mvpapp.presenter;

public interface ILoginPresenter {
    void doLogin(String email, String password);
    void setProgressBarVisibility(int visibility);
}
