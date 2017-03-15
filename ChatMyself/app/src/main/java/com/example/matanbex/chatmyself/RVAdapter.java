package com.example.matanbex.chatmyself;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import java.util.Calendar;
import java.util.List;


public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CustomViewHolder> {
    private List<String> messagesItemList;
    private Context mContext;
    private AdapterView.OnItemClickListener onItemClickListener;

    public RVAdapter(Context context, List<String> feedItemList) {
        this.messagesItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        System.out.println(i);
        final String feedItem = messagesItemList.get(i);
        Calendar c = Calendar.getInstance();
        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("HH:mm");
        String formattedDate = df.format(c.getTime());
        customViewHolder.textView.setText(formattedDate + " " + feedItem);
    }

    @Override
    public int getItemCount() {
        return (null != messagesItemList ? messagesItemList.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView textView;

        public CustomViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.message);
        }
    }

}