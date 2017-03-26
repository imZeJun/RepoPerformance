package browser.android.com.repoperformance.traceview;

import android.content.Context;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class TraceViewOperation {

    public static void writeOnAppOnCreateMainThread(Context context, int count) {
        writeSomething(context, count);
    }

    public static void writeOnAppOnCreateOtherThread(final Context context, final int count) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                writeSomething(context, count);
            }
        }.start();
    }

    public static void writeOnActivityOnCreate(Context context, int count) {
        writeSomething(context, count);
    }

    public static void writeOnActivityOnResume(final Context context, final int count) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                writeSomething(context, count);
            }
        }.start();
    }

    public static void writeSomething(Context context, int count) {
        FileOutputStream outputStream = null;
        try {
            outputStream = context.openFileOutput("traceview_" + Thread.currentThread().getId(), Context.MODE_APPEND);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            int i;
            for (i = 0; i < count; i++) {
               dataOutputStream.write(100);
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
