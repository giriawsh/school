package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import chapter.android.aweme.ss.com.homework.R;
/**
 * 作业1：
 * Logcat在屏幕旋转的时候 #onStop() #onDestroy()会展示出来
 * 但我们的 mLifecycleDisplay 由于生命周期的原因(Tips:执行#onStop()之后，UI界面我们是看不到的)并没有展示
 * 在原有@see Exercises1 基础上如何补全它，让其跟logcat的展示一样?
 * <p>
 * Tips：思考用比Activity的生命周期要长的来存储？  （比如：application、static变量）
 */
public class Exercises1 extends AppCompatActivity {
    private static final String TAG = "giria";

    private static final String ON_CREATE = "onCreate";
    private static final String ON_START = "onStart";
    private static final String ON_RESUME = "onResume";
    private static final String ON_PAUSE = "onPause";
    private static final String ON_STOP = "onStop";
    private static final String ON_RESTART = "onRestart";
    private static final String ON_DESTROY = "onDestroy";

    private static final ArrayList<String> lifeCycleCallbacks = new ArrayList<>();
    private TextView tvDisplay;

    private void textAppend(String string) {
        Log.d(TAG, "Lifecycle Event: " + string);
        tvDisplay.append(string + "\n");
    }

    public void resetLifecycleDisplay(View view) {
        tvDisplay.setText("Lifecycle callbacks:\n");
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lifecycle);
        this.tvDisplay = findViewById(R.id.textView_logLifecycle);
        tvDisplay.setText("Lifecycle callbacks:\n");

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("callbacks")) {
                String str = (String)savedInstanceState.get("callbacks");
                this.tvDisplay.setText(str);
            }
            for (String s : lifeCycleCallbacks) {
                TextView textView = this.tvDisplay;
                textView.append(s + "\n");
            }
        }
        lifeCycleCallbacks.clear();
        textAppend(ON_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifeCycleCallbacks.add(ON_DESTROY);
        textAppend(ON_DESTROY);
    }

    @Override
    protected void onPause() {
        super.onPause();
        textAppend(ON_PAUSE);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        textAppend(ON_RESTART);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textAppend(ON_RESUME);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textAppend(ON_START);
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifeCycleCallbacks.add(ON_STOP);
        textAppend(ON_STOP);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        textAppend("onSaveInstanceState");
        savedInstanceState.putString("callbacks", this.tvDisplay.getText().toString());
    }
}