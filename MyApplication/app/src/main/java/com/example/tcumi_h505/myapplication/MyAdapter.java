package com.example.tcumi_h505.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by tcumi_H505 on 2015/4/22.
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private Context mContext;//宣告一個參考用來指向mContext的LayoutInflater
    private static LayoutInflater inflater = null;//LayoutInflater是用來找res/layout/下的xml佈局檔

    private String[] groups;//建立參考，去指向資料源
    private String[][] children; //建立參考，去指向資料源
    Integer[][] pictures; //建立參考，去指向資料源

    public MyAdapter(Context c, String[] g, String[][] ch, Integer[][] p) {
        groups = g;
        children = ch;
        pictures = p;//將參考指向對應資料源
        mContext = c;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return groups.length;//幾個父列表
    }
    @Override
    public int getChildrenCount(int groupPosition) {
        return children[groupPosition].length;   //父列表下的
    } 						//子列表個數
    @Override
    public Object getGroup(int groupPosition) {
        return groups[groupPosition];//取得父列表內容
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return children[groupPosition][childPosition];
    }//取得父列表內子列表內容
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }//取得父列表Id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    } //取得子列表Id
    @Override
    public boolean hasStableIds() {//是否不同id總是參照相同對象
        return false;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }//子列表是否可以被選擇

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView textView = null;
        if(convertView==null){
            textView = new TextView(mContext);
        }else{
            textView=(TextView)convertView;
        }
        textView.setText(groups[groupPosition]);
        textView.setTextSize(30);
        textView.setPadding(50,10,0,10);//左 上 右 下
        return textView;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        view = inflater.inflate(R.layout.activity_child, null);
        TextView text = (TextView) view.findViewById(R.id.textView);
        text.setText(children[groupPosition][childPosition]);
        ImageView img = (ImageView)view.findViewById(R.id.imageView);
        img.setImageResource(pictures[groupPosition][childPosition]);
        return view;
    }
}
