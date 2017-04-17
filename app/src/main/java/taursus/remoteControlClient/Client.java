package taursus.remoteControlClient;

import taursus.remoteControl.*;

import java.io.IOException;
import java.net.Socket;

public class Client extends Transporter {
    protected Socket socket = null;
    protected String host = "10.0.2.2";
    protected int port = 4000;

    public Client(ILogger logger) {
        super(logger);
    }

    public Client setHost(String host) {
        this.host = host;
        return this;
    }

    public String getHost() {
        return this.host;
    }

    public Client setPort(int port) {
        this.port = port;
        return this;
    }

    public int getPort() {
        return this.port;
    }

    public void run() {
        try {
            this.socket = new Socket(this.host, this.port);
            this.output = this.socket.getOutputStream();
            this.input = this.socket.getInputStream();
            onConnected();
        } catch (IOException e) {
            e.printStackTrace();
            onConnectionFailed();
        }
    }

    protected void disconnect() {
        super.disconnect();

        if(this.isConnected) {
            try {
                this.socket.close();
                this.socket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
