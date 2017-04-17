package taursus.remoteControlClient.layoutRemoteControl;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControlClient.layoutRemoteControlOptions.RemoteControlOptionsLayout;

public class OptionsShowButton extends ViewBase implements IViewOnClickListener {

    public OptionsShowButton() {
        super();
        this.viewId = R.id.optionsShow;
    }

    public void onClick(View v) {
        this.layout.getActivity().changeLayout(new RemoteControlOptionsLayout());
    }
}
