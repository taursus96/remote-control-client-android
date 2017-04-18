package taursus.remoteControlClient.layoutConnectForm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import taursus.remoteControlClient.ISettingsRepository;
import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.activities.RemoteControlActivity;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class ConnectButton extends ViewBase implements IViewOnClickListener {
    protected Button view;
    protected HostEditText hostEditText;
    protected PortEditText portEditText;
    protected ISettingsRepository settingsRepository;

    public ConnectButton(HostEditText hostEditText, PortEditText portEditText, ISettingsRepository settingsRepository) {
        super();
        this.viewId = R.id.connectButton;
        this.hostEditText = hostEditText;
        this.portEditText = portEditText;
        this.settingsRepository = settingsRepository;
    }

    @Override
    public void onClick(View v) {
        String host = ((EditText)hostEditText.getView()).getText().toString();
        int port = Integer.valueOf(((EditText)portEditText.getView()).getText().toString());

        saveFormDataInSettingsRepository(host, port);
        startRemoteControlActivity();
    }

    protected void startRemoteControlActivity() {
        Intent intent = new Intent(this.layout.getActivity().getBaseContext(), RemoteControlActivity.class);
        this.layout.getActivity().startActivity(intent);
    }

    protected void saveFormDataInSettingsRepository(String host, int port) {
        this.settingsRepository.set("host", host);
        this.settingsRepository.setInt("port", port);
    }
}
