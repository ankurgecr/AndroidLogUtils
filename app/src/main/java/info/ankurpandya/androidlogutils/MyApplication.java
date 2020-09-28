package info.ankurpandya.androidlogutils;

import android.app.Application;

import info.ankurpandya.logutils.AppLogHelper;

/**
 * Create by Ankur @ Worktable.sg
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppLogHelper.setDebug(BuildConfig.DEBUG);
        AppLogHelper.setDefaultTag("LogTest");
    }
}
