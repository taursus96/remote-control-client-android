package taursus.remoteControlClient;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SettingsSharedPreferencesRepository implements ISettingsRepository {
    protected SharedPreferences sharedPreferences;
    protected List<IOnSettingChanged> onSettingChangedListeners = Collections.synchronizedList(new ArrayList<IOnSettingChanged>());

    public SettingsSharedPreferencesRepository(Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public void set(String name, String value) {
        this.sharedPreferences.edit().putString(name, value).apply();
        this.onChanged(name, value);
    }

    @Override
    public void setBool(String name, boolean value) {
        this.sharedPreferences.edit().putBoolean(name, value).apply();
        this.onChanged(name, value);
    }

    @Override
    public void setInt(String name, int value) {
        this.sharedPreferences.edit().putInt(name, value).apply();
        this.onChanged(name, value);
    }

    @Override
    public void setFloat(String name, float value) {
        this.sharedPreferences.edit().putFloat(name, value).apply();
        this.onChanged(name, value);
    }

    @Override
    public String get(String name, String defaultValue) {
        return this.sharedPreferences.getString(name, defaultValue);
    }

    @Override
    public boolean getBool(String name, boolean defaultValue) {
        return this.sharedPreferences.getBoolean(name, defaultValue);
    }

    @Override
    public int getInt(String name, int defaultValue) {
        return this.sharedPreferences.getInt(name, defaultValue);
    }

    @Override
    public float getFloat(String name, float defaultValue) {
        return this.sharedPreferences.getFloat(name, defaultValue);
    }

    public void onChanged(String name, Object value) {
        for(IOnSettingChanged listener: this.onSettingChangedListeners) {
            listener.onSettingsChanged(name, value);
        }
    }

    public void registerOnConnectedListener(IOnSettingChanged onSettingChanged) {
        this.onSettingChangedListeners.remove(onSettingChanged);
        this.onSettingChangedListeners.add(onSettingChanged);
    }

    public void removeOnConnectedListener(IOnSettingChanged onSettingChanged) {
        this.onSettingChangedListeners.remove(onSettingChanged);
    }
}
