package taursus.remoteControlClient.layoutConnectForm;

import taursus.remoteControlClient.activities.AppBaseActivity;
import taursus.remoteControlClient.simpleFramework.LayoutBase;
import taursus.remoteControlClient.R;

public class ConnectFormLayout extends LayoutBase {

    public ConnectFormLayout() {
        this.layoutId = R.layout.connect_form;
    }

    @Override
    protected void onInitialized() {
        HostEditText hostEditText = new HostEditText(AppBaseActivity.settingsRepository);
        PortEditText portEditText = new PortEditText(AppBaseActivity.settingsRepository);

        registerView(hostEditText);
        registerView(portEditText);
        registerView(new ConnectButton(hostEditText, portEditText, AppBaseActivity.settingsRepository));
    }
}
