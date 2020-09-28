package info.ankurpandya.androidlogutils;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import info.ankurpandya.logutils.AppLogHelper;

public class MainActivity extends AppCompatActivity {

    private View txtException;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtException = findViewById(R.id.txt_exception);
        txtException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                throwException();
            }
        });
        AppLogHelper.v("-- onCreate --");
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppLogHelper.d("-- onResume --");
    }

    private void throwException() {
        try {
            if (1 / 0 > 0) {
                AppLogHelper.i("It worked!");
            }
        } catch (Exception e) {
            AppLogHelper.printStackTrace(e);
        }
    }
}