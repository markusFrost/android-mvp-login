package mvp.android.testfor.com.androidmvplogin.view.custom.presentors;

import mvp.android.testfor.com.androidmvplogin.interfaces.LoginInteractor;
import mvp.android.testfor.com.androidmvplogin.interfaces.LoginPresenter;
import mvp.android.testfor.com.androidmvplogin.interfaces.LoginView;
import mvp.android.testfor.com.androidmvplogin.interfaces.OnLoginFinishedListener;

public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener {
    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;

    public LoginPresenterImpl(LoginView loginView){
        this.mLoginView = loginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String login, String password) {
        if ( mLoginView != null){
            mLoginView.showProgressBar();
        }

        mLoginInteractor.login(login, password, this);
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }

    @Override
    public void onLoginError() {
        if ( mLoginView != null){
            mLoginView.setLoginError();
            mLoginView.hideProgressBar();
        }
    }

    @Override
    public void onPasswordError() {
        if ( mLoginView != null){
            mLoginView.setPasswordError();
            mLoginView.hideProgressBar();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null){
            mLoginView.navigateToHome();
            mLoginView.hideProgressBar();
        }
    }
}
