package mvp.android.testfor.com.androidmvplogin.interfaces;


public interface LoginView {

    void showProgressBar();

    void hideProgressBar();

    void setLoginError();

    void setPasswordError();

    void navigateToHome();

}
