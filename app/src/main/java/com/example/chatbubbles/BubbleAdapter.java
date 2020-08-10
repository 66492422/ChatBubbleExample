package com.example.chatbubbles;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class BubbleAdapter extends BaseAdapter {

    private List<MessageItem> messages = new LinkedList<>();
    private Context mContext;

    public BubbleAdapter(Context context)
    {
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (null == view){
            view = LayoutInflater.from(mContext).inflate(R.layout.bubble_list_item, null);
        }

        //获取聊天信息项
        MessageItem item = getItem(position);

        //气泡信息
        LinearLayout bubbleMessage = view.findViewById(R.id.bubbleMessage);
        //通知信息
        LinearLayout noticeMessage = view.findViewById(R.id.noticeMessage);

        bubbleMessage.setVisibility((item.messageType == MessageItem.MessageType.Chat)?View.VISIBLE:View.GONE);
        noticeMessage.setVisibility((item.messageType == MessageItem.MessageType.Notice)?View.VISIBLE:View.GONE);

        if (item.messageType == MessageItem.MessageType.Chat)
        {
            //聊天气泡项内容布局
            LinearLayout contentLayout = view.findViewById(R.id.contentLayout);
            //聊天气泡来源三角标志 左 接收的信息
            ImageView left = view.findViewById(R.id.flagLeft);
            //聊天气泡来源三角标志 右 发送的信息
            ImageView right = view.findViewById(R.id.flagRight);
            //聊天文本内容
            TextView textMessage = view.findViewById(R.id.textMessage);
            //聊天图片内容
            ImageView imageMessage = view.findViewById(R.id.imageMessage);
            //聊天信息发送的时间
            TextView sendTime = view.findViewById(R.id.sendTime);

            //如果是发送的信息，则显示右三角标志，否者显示左三角标志
            right.setVisibility(((MessageItem.ChatMessage)item).isSend?View.VISIBLE:View.INVISIBLE);
            left.setVisibility(((MessageItem.ChatMessage)item).isSend?View.INVISIBLE:View.VISIBLE);

            //置聊天文本信息内容
            textMessage.setText(((MessageItem.ChatMessage)item).textMessage);
            //设置信息发送的时间
            sendTime.setText(((MessageItem.ChatMessage)item).sendTime.toString());

            //如果有图片信息则设置图片信息
            if (((MessageItem.ChatMessage)item).imageMessage != null)
            {
                imageMessage.setImageResource(R.drawable.nmsl);
                imageMessage.setVisibility(View.VISIBLE);
            } else {
                imageMessage.setVisibility(View.GONE);
            }

            //置气泡对齐方向，如果是来源信息则靠左对齐，如果是发送信息则靠右对齐
            bubbleMessage.setGravity(((MessageItem.ChatMessage)item).isSend?Gravity.END:Gravity.START);
            //通过信息来源设置聊天内容不同的背景风格
            contentLayout.setBackgroundResource(((MessageItem.ChatMessage)item).isSend?R.drawable.bubbles_background_right :R.drawable.bubbles_background_left);
        } else if (item.messageType == MessageItem.MessageType.Notice) {
            TextView noticeContent = view.findViewById(R.id.noticeContent);
            noticeContent.setText(((MessageItem.NoticeMessage)item).notice);
        }

        return view;
    }

    @Override
    public MessageItem getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    public void addItem(MessageItem item)
    {
        messages.add(item);
    }
}
