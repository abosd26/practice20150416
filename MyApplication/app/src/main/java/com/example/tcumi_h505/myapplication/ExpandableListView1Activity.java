package com.example.tcumi_h505.myapplication;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;


public class ExpandableListView1Activity extends ActionBarActivity {
    private MyAdapter adapter=new MyAdapter();
    private String[] groups={"台北市","花蓮縣","高雄市"};
    private String[][] childs={{"天龍區","文山區","大安區"},{"花蓮市","吉安鄉","玉里鎮"},{"不知道","懶得查","不重要","多一個"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view1);
        ExpandableListView listView = (ExpandableListView)findViewById(R.id.expandableListView);
        listView.setAdapter(adapter);
        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {//子列表事件監聽器
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String childName = (String) 	adapter.getChild(groupPosition,childPosition).toString();
                Toast.makeText(ExpandableListView1Activity.this, "Click : " + childName + " item", Toast.LENGTH_LONG).show();// 目標,訊息內容,訊息格式
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_expandable_list_view1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class MyAdapter extends BaseExpandableListAdapter{
        @Override
        public int getGroupCount() {
            return groups.length;//幾個父列表
        }
        @Override
        public int getChildrenCount(int groupPosition) {
            return childs[groupPosition].length;   //父列表下的
        } 						//子列表個數
        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];//取得父列表內容
        }
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childs[groupPosition][childPosition];
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
        @Override//父列表視圖的內容
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null){//有沒有舊的view可以使用
                textView = new TextView(ExpandableListView1Activity.this);
            }else{
                textView=(TextView)convertView;
            }
            textView.setText(groups[groupPosition]);
            textView.setTextSize(30);
            textView.setPadding(50,10,0,10);//左 上 右 下
            return textView;
        }
        @Override//子列表視圖的內容
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView textView = null;
            if(convertView==null){
                textView = new TextView(ExpandableListView1Activity.this);
            }else{
                textView=(TextView)convertView;
            }
            textView.setText(childs[groupPosition][childPosition]);
            textView.setTextSize(20);
            textView.setPadding(72,10,0,10);
            return textView;
        }

    }
}
