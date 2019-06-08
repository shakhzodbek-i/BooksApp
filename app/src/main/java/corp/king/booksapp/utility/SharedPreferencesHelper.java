package corp.king.booksapp.utility;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import corp.king.booksapp.App;

public class SharedPreferencesHelper {
    @Inject
    Context mContext;

    private SharedPreferences sharedPreferences;
    private static final String SHARED_PREFERENCE_ACCESSOR = "pims_shared_preference";

    public SharedPreferencesHelper(App app) {
        sharedPreferences = app.getSharedPreferences(SHARED_PREFERENCE_ACCESSOR, Context.MODE_PRIVATE);
    }

    public void saveString(String value, String key) {
        sharedPreferences
                .edit()
                .putString(key, value)
                .apply();
    }

    public void saveInt(int value, String key) {
        sharedPreferences
                .edit()
                .putInt(key, value)
                .apply();

    }

    public String getString(String key) {
        return  sharedPreferences.getString(key, "ERROR!");
    }

    public int getInt(String key) {
        return sharedPreferences.getInt(key, -1);
    }
}
