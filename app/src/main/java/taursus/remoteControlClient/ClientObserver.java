package taursus.remoteControlClient;

import taursus.remoteControlClient.activities.RemoteControlActivity;
import taursus.remoteControl.ILogger;
import taursus.remoteControl.IOnConnected;
import taursus.remoteControl.IOnConnectionFailed;
import taursus.remoteControl.IOnDisconnected;

public class ClientObserver implements IOnConnectionFailed, IOnDisconnected {
    RemoteControlActivity remoteControlActivity;
    Client client;

    public ClientObserver(RemoteControlActivity remoteControlActivity, Client client) {
        this.remoteControlActivity = remoteControlActivity;
        this.client = client;

        this.client.registerOnDisconnectedListener(this);
        this.client.registerOnConnectionFailedListener(this);
    }

    @Override
    public void onConnectionFailed() {
        this.remoteControlActivity.openMainActivity();
    }

    @Override
    public void onDisconnected() {
        this.remoteControlActivity.openMainActivity();
    }
}
