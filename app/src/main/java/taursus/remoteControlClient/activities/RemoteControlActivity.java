package taursus.remoteControlClient.activities;

import android.content.Intent;
import android.os.Bundle;

import taursus.remoteControlClient.Client;
import taursus.remoteControlClient.ClientObserver;
import taursus.remoteControlClient.Logger;
import taursus.remoteControlClient.LoggerFactory;
import taursus.remoteControlClient.OSReceiver;
import taursus.remoteControlClient.activities.ConnectFormActivity;
import taursus.remoteControlClient.layoutRemoteControl.RemoteControlLayout;
import taursus.remoteControlClient.simpleFramework.ActivityBase;
import taursus.remoteControl.EventDataSerializer;

public class RemoteControlActivity extends ActivityBase {
	protected Client client = new Client(LoggerFactory.create());

    public Client getClient() {
        return this.client;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int port = getIntent().getIntExtra("port", 4000);
        String host = getIntent().getStringExtra("host");

        ClientObserver clientObserver = new ClientObserver(this, this.client);

        this.client.setPort(port);
        this.client.setHost(host);
        this.client.init();

        changeLayout(new RemoteControlLayout());
    }

    public void openMainActivity() {
        this.client.close();
        Intent intent = new Intent(getBaseContext(), ConnectFormActivity.class);
        startActivity(intent);
    }
}
