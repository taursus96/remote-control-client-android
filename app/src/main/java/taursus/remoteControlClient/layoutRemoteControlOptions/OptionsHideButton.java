package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControlClient.layoutRemoteControl.RemoteControlLayout;

public class OptionsHideButton extends ViewBase implements IViewOnClickListener {

    public OptionsHideButton() {
        super();
        this.viewId = R.id.optionsHide;
    }


    public void onClick(View v) {
        this.layout.getActivity().changeLayout(new RemoteControlLayout());
    }
}
