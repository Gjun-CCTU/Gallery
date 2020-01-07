package com.example.gjungallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Toast;

import java.nio.channels.GatheringByteChannel;

public class MainActivity extends AppCompatActivity {
    Gallery gallery;
    ImageView IV;
    ViewPager vp;
    int images[] = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5,
            R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10,
            R.drawable.a11, R.drawable.a12, R.drawable.a13, R.drawable.a14, R.drawable.a15, R.drawable.a16};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IV = (ImageView) findViewById(R.id.imageView);
        gallery = (Gallery) findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(MainActivity.this));
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             IV.setImageResource(images[position]);
                Toast.makeText(MainActivity.this, "NO."+ (position + 1), Toast.LENGTH_SHORT ).show();
            }
        });
    }

    public class ImageAdapter extends BaseAdapter {
        Context context;
        int bgColor;
        public ImageAdapter(Context ct){
            this.context = ct;
            TypedArray TA =  context.obtainStyledAttributes(R.styleable.MyTheme);
            bgColor = TA.getResourceId(R.styleable.MyTheme_android_galleryItemBackground, 0);
            TA.recycle();
        }
        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv;
            if(convertView == null){
               iv = new ImageView(context);
               iv.setBackgroundResource(bgColor);
               iv.setScaleType(ImageView.ScaleType.FIT_XY);
               iv.setLayoutParams(new Gallery.LayoutParams(150, 200));
            }else{
                iv = (ImageView)convertView;
            }
            iv.setImageResource(images[position]);
            return iv;
        }
    }
}
