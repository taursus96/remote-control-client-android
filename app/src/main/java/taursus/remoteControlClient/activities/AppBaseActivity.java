package taursus.remoteControlClient.activities;

import android.content.Intent;
import android.os.Bundle;

import taursus.remoteControlClient.ISettingsRepository;
import taursus.remoteControlClient.SettingsSharedPreferencesRepository;
import taursus.remoteControlClient.layoutConnectForm.ConnectFormLayout;
import taursus.remoteControlClient.simpleFramework.ActivityBase;

public class AppBaseActivity extends ActivityBase {
    public static ISettingsRepository settingsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppBaseActivity.settingsRepository = new SettingsSharedPreferencesRepository(getBaseContext());

        runStartingActivity();
    }

    protected void runStartingActivity() {
        Intent intent = new Intent(getBaseContext(), ConnectFormActivity.class);
        startActivity(intent);
    }
}
