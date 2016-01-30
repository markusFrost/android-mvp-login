package mvp.android.testfor.com.androidmvplogin.interfaces;


public interface LoginPresenter {
    void validateCredentials(String login, String password);

    void onDestroy();
}
