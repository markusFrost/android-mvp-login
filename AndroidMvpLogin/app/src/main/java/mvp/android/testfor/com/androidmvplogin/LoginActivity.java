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

public class LoginActivity extends Activity {

    @Bind(R.id.editUserName)
    EditText editUserName;

    @Bind(R.id.editPassword)
    EditText editPass;

    @Bind(R.id.pb)
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnLogIn)
    public void submit() {
       fakeLoad(editUserName.getText().toString(), editPass.getText().toString());
    }

    private void showProgressBar(){
        pb.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        pb.setVisibility(View.GONE);
    }

    private void fakeLoad(final String login, final String password){
        Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                showProgressBar();
                validateForm(login, password);
                hideProgressBar();
            }
        };
        handler.postDelayed(runnable, 2000);
    }

    private void validateForm(String login, String password){
        if (TextUtils.isEmpty(login) && TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this, "form is empty", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(login)) {
            Toast.makeText(LoginActivity.this, "login is empty", Toast.LENGTH_SHORT).show();
        }
        else if ( TextUtils.isEmpty(password)){
            Toast.makeText(LoginActivity.this, "pass is empty", Toast.LENGTH_SHORT).show();
        }
        else{
            startActivity(new Intent(LoginActivity.this, SecondActivity.class));
        }
    }
}
