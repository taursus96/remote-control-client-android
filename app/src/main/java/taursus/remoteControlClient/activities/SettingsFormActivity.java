package taursus.remoteControlClient.activities;

import android.os.Bundle;

import taursus.remoteControlClient.layoutSettingsForm.SettingsFormLayout;
import taursus.remoteControlClient.simpleFramework.ActivityBase;

public class SettingsFormActivity extends ActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeLayout(new SettingsFormLayout());
    }


}
