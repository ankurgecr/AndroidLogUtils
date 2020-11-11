package info.ankurpandya.logutils;

import android.util.Log;

public class AppLogHelper {

    private static boolean IS_DEBUG = false;
    private static String DEFAULT_TAG = "AppLog";

    public static void setDebug(boolean isDebug) {
        IS_DEBUG = isDebug;
    }

    public static void setDefaultTag(String defaultTag) {
        DEFAULT_TAG = defaultTag;
    }

    public static void d(String message) {
        d(DEFAULT_TAG, message);
    }

    public static void v(String message) {
        v(DEFAULT_TAG, message);
    }

    public static void e(String message) {
        e(DEFAULT_TAG, message);
    }

    public static void i(String message) {
        i(DEFAULT_TAG, message);
    }

    public static void e(String tag, String message) {
        log('e', tag, message);
    }

    public static void e(String tag, String message, Throwable e) {
        log('e', tag, message);
        printStackTrace(e);
    }

    public static void d(String tag, String message) {
        d(tag, message, null);
    }

    public static void w(String tag, String message) {
        w(tag, message, null);
    }

    public static void w(String tag, Exception e) {
        w(tag, "", e);
    }

    public static void i(String tag, String message) {
        log('i', tag, message);
    }

    public static void v(String tag, String message) {
        log('v', tag, message);
    }

    public static void d(String tag, String message, Exception exception) {
        if (exception != null) {
            if (message == null) {
                message = "null";
            }
            message += " " + exception.getMessage();
        }
        log('d', tag, message);
    }

    public static void w(String tag, String message, Exception exception) {
        if (exception != null) {
            if (message == null) {
                message = "null";
            }
            message += " " + exception.getMessage();
        }
        log('w', tag, message);
    }

    private static void log(char type, String tag, String message) {
        if (!IS_DEBUG) {
            //Crashlytics.log(0, tag, message);
            //Bugfender.d(tag, message);
            return;
        }
        if (message == null) {
            message = "null";
        }
        if (message.length() > 4000) {
            int chunkCount = message.length() / 4000;     // integer division
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= message.length()) {
                    print(type, tag, message.substring(4000 * i));
                } else {
                    print(type, tag, message.substring(4000 * i, max));
                }
            }
        } else {
            print(type, tag, message);
        }
    }

    private static void print(char type, String tag, String message) {
        switch (type) {
            case 'e':
                Log.e(tag, message);
                break;
            case 'd':
                Log.d(tag, message);
                break;
            case 'w':
                Log.w(tag, message);
                break;
            case 'i':
                Log.i(tag, message);
                break;
            case 'v':
            default:
                Log.v(tag, message);
                break;
        }
    }

    public static void printStackTrace(Throwable e) {
        if (e == null) {
            return;
        }
        if (IS_DEBUG) {
            e.printStackTrace();
        } else {
            //FirebaseCrashlytics.getInstance().recordException(e);
        }
    }
}
