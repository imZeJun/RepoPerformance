package browser.android.com.repoperformance.tracker;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

public class TrackerObject {

    List<Bitmap> mBitmaps = new ArrayList<>();

    public void allocBitmaps() {
        for (int i = 0; i < 100; i++) {
            Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
            mBitmaps.add(bitmap);
        }
    }

    public void releaseBitmaps() {
        for (Bitmap bitmap : mBitmaps) {
            bitmap.recycle();
        }
        mBitmaps.clear();
    }
}
