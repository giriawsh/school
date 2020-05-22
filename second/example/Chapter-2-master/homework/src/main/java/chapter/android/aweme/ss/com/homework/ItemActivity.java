package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

public class ItemActivity extends AppCompatActivity implements MyAdapter.ListItemClickListener {
    //这种写法没法加载chatroom竟然会闪退?! 日后再研究一下

    private MyAdapter mAdapter;
    private static final String TAG = "ItemViews";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        //设置Manager，即设置其样式
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }


    @Override
    public void onListItemClick(String chat_target, int positionIndex) {

    }
}