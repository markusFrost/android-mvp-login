package mvp.android.testfor.com.androidmvplogin.view.custom.presentors;

import android.os.Handler;
import android.text.TextUtils;

import mvp.android.testfor.com.androidmvplogin.interfaces.LoginInteractor;
import mvp.android.testfor.com.androidmvplogin.interfaces.OnLoginFinishedListener;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String login, final String password, final OnLoginFinishedListener listener) {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(login)){
                    listener.onLoginError();
                }
                else if ( TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                }
                else{
                    listener.onSuccess();
                }
            }
        };
        handler.postDelayed(runnable,2000);
    }
}
