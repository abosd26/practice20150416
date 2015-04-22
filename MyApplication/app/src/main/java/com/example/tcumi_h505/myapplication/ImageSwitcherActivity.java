package com.example.tcumi_h505.myapplication;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


public class ImageSwitcherActivity extends ActionBarActivity {
    private ImageSwitcher imageSwitcher;
    private Integer[] images = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9};
    private Button btn_next, btn_last;
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageSwitcher);
        btn_last = (Button)findViewById(R.id.button);
        btn_next = (Button)findViewById(R.id.button2);
        imageSwitcher.setFactory(new ImageViewFactory(this));
        imageSwitcher.setImageResource(images[index]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onClickLast(View v)
    {
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_right));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_out_left));
        if(index >= 0 && index < images.length)
        {
            index--;
            if(index < 0)
                index = images.length-1;
            imageSwitcher.setImageResource(images[index]);
        }
    }
    public void onClickNext(View v)
    {
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right));
        if(index >= 0 && index < images.length-1)
        {
            index++;
            imageSwitcher.setImageResource(images[index]);
        }else
        {
            index=0;
            imageSwitcher.setImageResource(images[index]);
        }
    }


}
class ImageViewFactory implements ViewSwitcher.ViewFactory {
    private Context context;

    public ImageViewFactory(Context context)
    {
        this.context = context;
    }

    @Override
    public View makeView() {
        ImageView iv = new ImageView(this.context);
        return iv;
    }
}