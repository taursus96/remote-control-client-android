package taursus.remoteControlClient.simpleFramework;

import java.util.ArrayList;
import java.util.List;

public abstract class LayoutBase {
    protected int layoutId;
    protected ActivityBase activity;
    protected List<ViewBase> views = new ArrayList<>();

    public void init(ActivityBase activity) {
        this.activity = activity;
        this.activity.setContentView(this.layoutId);
        this.onInitialized();
    }

    public ActivityBase getActivity() {
        return this.activity;
    }

    protected void registerView(ViewBase view) {
        views.add(view);
        view.init(this);
    }

    protected abstract void onInitialized();

    protected void close() {
        for(ViewBase view : this.views) {
            view.close();
        }
    }
}
