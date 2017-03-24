package browser.android.com.repoperformance;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Trace;
import android.view.View;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class SystraceActivity extends Activity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_systrace);
        Trace.beginSection("TextView animation");
        mTv = (TextView) findViewById(R.id.tv_to_anim);
        mTv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startAnimator();
            }
        });
        Trace.endSection();
    }

    private void startAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1f);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mTv.setAlpha((float) animation.getAnimatedValue());
                writeSomething();
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }

    private void writeSomething() {
        OutputStream outputStream = null;
        try {
            outputStream = openFileOutput("systrace", MODE_APPEND);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            for (int i = 0; i < 10000; i++) {
                dataOutputStream.write(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
