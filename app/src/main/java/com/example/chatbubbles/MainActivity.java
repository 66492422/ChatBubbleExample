package com.example.chatbubbles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    private ListView mDemoBubble = null;
    private BubbleAdapter mBubbleAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemoBubble = findViewById(R.id.DemoBubble);
        mBubbleAdapter = new BubbleAdapter(this);
        mDemoBubble.setAdapter(mBubbleAdapter);

        mBubbleAdapter.addItem(new MessageItem.NoticeMessage("2020-8-10"));

        mBubbleAdapter.addItem(new MessageItem.ChatMessage("Hello World", null, new Time(System.currentTimeMillis()), true));
        mBubbleAdapter.addItem(new MessageItem.ChatMessage("FUCK OFF", null, new Time(System.currentTimeMillis()), false));
        mBubbleAdapter.addItem(new MessageItem.NoticeMessage("对方开启了加密模式"));
        mBubbleAdapter.addItem(new MessageItem.ChatMessage("那没事了", "nmsl", new Time(System.currentTimeMillis()), true));
        mBubbleAdapter.addItem(new MessageItem.ChatMessage("提着灯闯过远洋的甄选 继续下潜 无需誓言 我的心像自沉的旧母舰 没入深渊 永别啊 我曾凝望 曾是航向的日出 末路残烛 容我吹熄 藏起火种 向宇宙远渡 点燃星 亲手点燃目光尽头的准星 让夜降临 让陨石 重启如萤火虫闪烁的飞行 破灭魂灵 点燃星 亲手点燃黑暗森林的火星 蒙昧初醒 而我却 轻声告别这新生的黎明 执念的鱼 孤独着闯过自然的甄选 文明岸边 无需誓言 我的心像重启的旧母舰 去星云巅 永别啊 我曾凝望曾是航向的日出 末路残烛 容我吹熄 藏起火种 向宇宙远渡 我是星 利剑开刃寒光锋芒的银星 绝不消隐 不回顾 永难再折返的故园的光阴", null, new Time(System.currentTimeMillis()), false));
        mBubbleAdapter.addItem(new MessageItem.ChatMessage("FUCK OFF", null, new Time(System.currentTimeMillis()), false));
        mBubbleAdapter.addItem(new MessageItem.NoticeMessage("对方关闭了加密模式"));


        mBubbleAdapter.notifyDataSetChanged();
    }
}
