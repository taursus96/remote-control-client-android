package taursus.remoteControlClient.layoutConnectForm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import taursus.remoteControlClient.simpleFramework.IViewOnClickListener;
import taursus.remoteControlClient.R;
import taursus.remoteControlClient.activities.RemoteControlActivity;
import taursus.remoteControlClient.simpleFramework.ViewBase;

public class ConnectButton extends ViewBase implements IViewOnClickListener {
    protected Button view;
    protected HostEditText hostEditText;
    protected PortEditText portEditText;

    public ConnectButton(HostEditText hostEditText, PortEditText portEditText) {
        super();
        this.viewId = R.id.connectButton;
        this.hostEditText = hostEditText;
        this.portEditText = portEditText;
    }

    @Override
    public void onClick(View v) {
        String host = ((EditText)hostEditText.getView()).getText().toString();
        int port = Integer.valueOf(((EditText)portEditText.getView()).getText().toString());

        saveFormDataInSharedPreferences(host, port);
        startRemoteControlActivity(host, port);
    }

    protected void startRemoteControlActivity(String host, int port) {
        Intent intent = new Intent(this.layout.getActivity().getBaseContext(), RemoteControlActivity.class);
        intent.putExtra("host", host);
        intent.putExtra("port", port);
        this.layout.getActivity().startActivity(intent);
    }

    protected void saveFormDataInSharedPreferences(String host, int port) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this.layout.getActivity().getBaseContext()).edit();
        editor.putString("host", host);
        editor.putInt("port", port);
        editor.apply();
    }
}
