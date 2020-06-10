package com.bytedance.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.button1);
        final TextView tv1 = findViewById(R.id.textView1);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv1.setText("第一个手机应用好像很炫酷的样子！");
            }
        });
        RadioGroup radgroup = (RadioGroup) findViewById(R.id.radioGroup);
        radgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkId){
                RadioButton radbtn = (RadioButton) findViewById(checkId);
//                Toast.makeText(getApplicationContext(), "Button changed!"+radbtn.getText(),Toast.LENGTH_LONG);
                tv1.setText("Button changed!"+radbtn.getText());
            }
        });
        Log.d(TAG, "MainActivity");
    }
}
