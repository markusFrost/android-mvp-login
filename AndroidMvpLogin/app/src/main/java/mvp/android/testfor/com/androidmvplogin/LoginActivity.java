package mvp.android.testfor.com.androidmvplogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;



import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.android.testfor.com.androidmvplogin.interfaces.LoginPresenter;
import mvp.android.testfor.com.androidmvplogin.interfaces.LoginView;
import mvp.android.testfor.com.androidmvplogin.view.custom.presentors.LoginPresenterImpl;

public class LoginActivity extends Activity implements LoginView {

    @Bind(R.id.editUserName)
    EditText editLogin;

    @Bind(R.id.editPassword)
    EditText editPass;

    @Bind(R.id.pb)
    ProgressBar pb;

    private LoginPresenter iLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        iLoginPresenter = new LoginPresenterImpl(this);

    }

    @OnClick(R.id.btnLogIn)
    public void submit() {
        iLoginPresenter.validateCredentials(editLogin.getText().toString(), editPass.getText().toString());
    }

    @Override
    public void showProgressBar() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void setLoginError() {
        Toast.makeText(LoginActivity.this, "login error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(LoginActivity.this, "password error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, SecondActivity.class));
    }
}
