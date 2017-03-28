package browser.android.com.repoperformance;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import browser.android.com.repoperformance.tracker.TrackerObject;

public class TrackerActivity extends Activity {

    private TrackerObject mTrackerObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);
        mTrackerObject = new TrackerObject();
    }

    public void alloc(View view) {
        mTrackerObject.allocBitmaps();
    }

    public void release(View view) {
        mTrackerObject.releaseBitmaps();
    }
}
