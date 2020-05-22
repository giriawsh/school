package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;


import java.io.InputStream;
import java.util.List;
import chapter.android.aweme.ss.com.homework.model.PullParser;
import chapter.android.aweme.ss.com.homework.model.Message;

public class Exercises3 extends AppCompatActivity implements MyAdapter.ListItemClickListener {

    private MyAdapter mAdapter;
    private List<Message> messages;
    private Toast mToast;
    private static final String TAG = "ItemViews";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        //按提示取得数据
        try {
            InputStream assetInput = getAssets().open("data.xml");
            messages = PullParser.pull2xml(assetInput);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        RecyclerView recycleView = findViewById(R.id.rv_list);

        //线性布局manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(layoutManager);
        recycleView.setHasFixedSize(true);//适配问题

        mAdapter = new MyAdapter(messages, this);//传入数据

        recycleView.setAdapter(mAdapter);//fix bug
    }

    @Override
    public void onListItemClick(String target, int positionIndex) {
        // 暂时先按原先toast出标号吧.
        Log.d(TAG, "onListItemClick: ");
        if (mToast != null) {
            mToast.cancel();
        }
        String toastMessage = "Item #" + positionIndex + " clicked.";
        mToast = Toast.makeText(this, toastMessage, Toast.LENGTH_LONG);

        mToast.show();
//        Intent intent = new Intent(this, ItemActivity.class);
//        intent.putExtra("target", target);
//        startActivity(intent);
        // something wrong after click the item button. The programme crash down immediately??

    }


}