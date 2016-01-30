package mvp.android.testfor.com.androidmvplogin.view.custom.presentors;

import android.os.Handler;
import android.text.TextUtils;

import mvp.android.testfor.com.androidmvplogin.interfaces.LoginInteractor;
import mvp.android.testfor.com.androidmvplogin.interfaces.OnLoginFinishedListener;

public class LoginInteractorImpl implements LoginInteractor {

    private OnLoginFinishedListener mOnLoginFinishedListener;

    public LoginInteractorImpl(OnLoginFinishedListener onLoginFinishedListener){
        this.mOnLoginFinishedListener = onLoginFinishedListener;
    }

    @Override
    public void login(final String login, final String password ) {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (TextUtils.isEmpty(login)){
                    mOnLoginFinishedListener.onLoginError();
                }
                else if ( TextUtils.isEmpty(password)){
                    mOnLoginFinishedListener.onPasswordError();
                }
                else{
                    mOnLoginFinishedListener.onSuccess();
                }
            }
        };
        handler.postDelayed(runnable,2000);
    }
}
