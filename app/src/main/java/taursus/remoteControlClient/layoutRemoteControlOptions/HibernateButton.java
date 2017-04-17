package taursus.remoteControlClient.layoutRemoteControlOptions;

import android.view.View;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.simpleFramework.ViewBase;
import taursus.remoteControl.IOptionsControl;

public class HibernateButton extends ViewBase implements IViewOnClickListener {
    protected IOptionsControl optionsControl;

    public HibernateButton(IOptionsControl optionsControl) {
        super();
        this.optionsControl = optionsControl;
        this.viewId = R.id.optionHibernate;
    }

    public void onClick(View v) {
        this.optionsControl.hibernate();
    }
}
