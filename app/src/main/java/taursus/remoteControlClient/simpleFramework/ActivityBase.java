package taursus.remoteControlClient.simpleFramework;

import android.support.v7.app.AppCompatActivity;

public abstract class ActivityBase extends AppCompatActivity {
    protected LayoutBase currentLayout;

    public void changeLayout(LayoutBase layout) {
        if(this.currentLayout != null) {
            currentLayout.close();
        }

        runOnUiThread(new Runnable(){
            @Override
            public void run(){
                layout.init(ActivityBase.this);
            }
        });

        this.currentLayout = layout;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(this.currentLayout != null) {
            currentLayout.close();
        }
    }
}
