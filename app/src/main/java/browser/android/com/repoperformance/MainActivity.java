package browser.android.com.repoperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final long ITERATOR_NUM = 10000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over_draw_layout);
        traceView();
    }

    private void traceView() {
        traceViewInner();
    }

    private void traceViewInner() {
        long result = 0;
        for (int i = 0 ; i < ITERATOR_NUM; i++) {
            result += i;
        }
        Log.d(TAG, "traceViewInner, result=" + result);
    }
}
