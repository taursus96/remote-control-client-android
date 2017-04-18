package taursus.remoteControlClient.layoutConnectForm;

import android.preference.PreferenceManager;
import android.widget.EditText;

import taursus.remoteControlClient.ISettingsRepository;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.activities.AppBaseActivity;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class HostEditText extends ViewBase {
    ISettingsRepository settingsRepository;

    public HostEditText(ISettingsRepository settingsRepository) {
        super();
        this.viewId = R.id.hostEditText;
        this.settingsRepository = settingsRepository;
    }

    public EditText getView() {
        return (EditText) this.view;
    }

    @Override
    public void onInitialized() {
        String defaultHost = this.settingsRepository.get("host", "10.0.2.2");
        this.getView().setText(defaultHost);
    }
}
