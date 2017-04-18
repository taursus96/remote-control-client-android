package taursus.remoteControlClient.layoutSettingsForm;

import taursus.remoteControlClient.R;
import taursus.remoteControlClient.activities.AppBaseActivity;
import taursus.remoteControlClient.simpleFramework.LayoutBase;

public class SettingsFormLayout extends LayoutBase {

    public SettingsFormLayout() {
        this.layoutId = R.layout.settings_form;
    }

    @Override
    protected void onInitialized() {
        ScrollSensitivityEditText scrollSensitivityEditText = new ScrollSensitivityEditText(AppBaseActivity.settingsRepository);
        MouseMovementSensitivityEditText mouseMovementSensitivityEditText = new MouseMovementSensitivityEditText(AppBaseActivity.settingsRepository);

        registerView(scrollSensitivityEditText);
        registerView(mouseMovementSensitivityEditText);
        registerView(new SettingsHideButton());
    }
}
