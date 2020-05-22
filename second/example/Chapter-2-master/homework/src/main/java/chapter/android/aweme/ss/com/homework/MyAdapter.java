package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;

//重写适配器

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<Message> mData;
    private final ListItemClickListener mOnClickListener;

    MyAdapter(List<Message> data, ListItemClickListener listener){
        this.mData = data;
        this.mOnClickListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        Message message = mData.get(position);
        myViewHolder.updateUI(message);
    }

    @Override
    public int getItemCount() {

        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //title
        private final TextView view_tv_title;
        private final TextView view_tv_description;
        private final TextView view_tv_time;
        private final ImageView view_iv_avatar;
        private final ImageView view_robot_notice;
        MyViewHolder(@NonNull View itemView){
            super(itemView);
            view_tv_title = itemView.findViewById(R.id.tv_title);
            view_tv_description = itemView.findViewById(R.id.tv_description);
            view_tv_time = itemView.findViewById(R.id.tv_time);
            view_iv_avatar = itemView.findViewById(R.id.iv_avatar);
            view_robot_notice = itemView.findViewById(R.id.robot_notice);
            itemView.setOnClickListener(this);
        }

        void updateUI(Message message){
            //设置名称，描述，时间
            view_tv_title.setText(message.getTitle());
            view_tv_description.setText(message.getDescription());
            view_tv_time.setText(message.getTime());

            switch (message.getIcon()) {
                case "TYPE_ROBOT":
                    view_iv_avatar.setImageResource(R.drawable.session_robot);
                    break;
                case "TYPE_GAME":
                    view_iv_avatar.setImageResource(R.drawable.icon_micro_game_comment);
                    break;
                case "TYPE_SYSTEM":
                    view_iv_avatar.setImageResource(R.drawable.session_system_notice);
                    break;
                case "TYPE_USER":
                    view_iv_avatar.setImageResource(R.drawable.icon_girl);
                    break;
                case "TYPE_STRANGER":
                    view_iv_avatar.setImageResource(R.drawable.session_stranger);
                    break;
            }

//            System.out.print(message.isOfficial());

            if(message.isOfficial()) {
                view_robot_notice.setImageResource(R.drawable.im_icon_notice_official);
                view_robot_notice.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(view_tv_title.getText().toString(), clickedPosition);
            }
        }

    }
    public interface ListItemClickListener {
        void onListItemClick(String target, int positionIndex);

    }
}