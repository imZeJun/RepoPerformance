package browser.android.com.repoperformance.traceview;

import android.app.Application;

public class TraceViewApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TraceViewOperation.writeOnAppOnCreateMainThread(this, 100);
        TraceViewOperation.writeOnAppOnCreateOtherThread(this, 100);
    }

}
