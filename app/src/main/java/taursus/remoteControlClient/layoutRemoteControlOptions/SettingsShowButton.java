package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.R;
import taursus.remoteControlClient.layoutRemoteControl.RemoteControlLayout;
import taursus.remoteControlClient.layoutSettingsForm.SettingsFormLayout;
import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class SettingsShowButton extends ViewBase implements IViewOnClickListener {

    public SettingsShowButton() {
        super();
        this.viewId = R.id.settingsShow;
    }


    public void onClick(View v) {
        this.layout.getActivity().changeLayout(new SettingsFormLayout());
    }
}
