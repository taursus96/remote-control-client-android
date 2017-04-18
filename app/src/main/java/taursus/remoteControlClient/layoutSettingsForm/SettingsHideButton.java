package taursus.remoteControlClient.layoutSettingsForm;

import android.view.View;

import taursus.remoteControlClient.R;
import taursus.remoteControlClient.layoutRemoteControl.RemoteControlLayout;
import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class SettingsHideButton extends ViewBase implements IViewOnClickListener {

    public SettingsHideButton() {
        super();
        this.viewId = R.id.settingsHide;
    }


    public void onClick(View v) {
        this.layout.getActivity().changeLayout(new RemoteControlLayout());
    }
}
