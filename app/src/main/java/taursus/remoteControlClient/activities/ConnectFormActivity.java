package taursus.remoteControlClient.activities;

import android.os.Bundle;

import taursus.remoteControlClient.layoutConnectForm.ConnectFormLayout;
import taursus.remoteControlClient.simpleFramework.ActivityBase;

public class ConnectFormActivity extends ActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeLayout(new ConnectFormLayout());
    }


}
