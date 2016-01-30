package mvp.android.testfor.com.androidmvplogin.view.custom;

import android.content.Context;

public class EditText extends android.widget.EditText {
    public EditText(Context context) {
        super(context);
    }

    @Override
    public String toString() {
        return this.getText().toString();
    }
}
