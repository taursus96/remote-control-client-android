package taursus.remoteControlClient.layoutConnectForm;

import taursus.remoteControlClient.simpleFramework.LayoutBase;
import taursus.remoteControlClient.R;

public class ConnectFormLayout extends LayoutBase {

    public ConnectFormLayout() {
        this.layoutId = R.layout.connect_form;
    }

    @Override
    protected void onInitialized() {
        HostEditText hostEditText = new HostEditText();
        PortEditText portEditText = new PortEditText();

        registerView(hostEditText);
        registerView(portEditText);
        registerView(new ConnectButton(hostEditText, portEditText));
    }
}
