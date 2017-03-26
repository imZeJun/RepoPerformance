package browser.android.com.repoperformance;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import browser.android.com.repoperformance.traceview.TraceViewOperation;

public class TraceViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace_view);
        TraceViewOperation.writeOnActivityOnCreate(this, 1000);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TraceViewOperation.writeOnActivityOnResume(this, 1000);
    }

}
