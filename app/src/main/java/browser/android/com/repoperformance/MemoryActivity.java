package browser.android.com.repoperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import browser.android.com.repoperformance.memory.MemorySingleton;

public class MemoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        MemorySingleton.getInstance(this);
    }
}
