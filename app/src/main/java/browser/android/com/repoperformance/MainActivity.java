package browser.android.com.repoperformance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over_draw_layout);
    }

    public void sysTraceActivity(View view) {
        Intent intent = new Intent(this, SystraceActivity.class);
        startActivity(intent);
    }

}
