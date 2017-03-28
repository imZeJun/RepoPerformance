package browser.android.com.repoperformance.memory;


import android.content.Context;

public class MemorySingleton {
    private static MemorySingleton sInstance;
    private ObjectA objectA;
    private ObjectE objectE;
    private ObjectF objectF;
    private Context mContext;

    public static synchronized MemorySingleton getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new MemorySingleton(context);
        }
        return sInstance;
    }

    private MemorySingleton(Context context) {
        objectA = new ObjectA();
        objectE = new ObjectE();
        objectF = new ObjectF();
        objectE.setObjectF(objectF);
        mContext = context;
    }

}
