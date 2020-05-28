package me.nereo.multiimageselector;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImageActivity extends AppCompatActivity {

    private PicGallery gallery;
    private GalleryAdapter mAdapter;
    // 屏幕宽度
    public static int screenWidth;
    // 屏幕高度
    public static int screenHeight;

    private ArrayList<Bitmap> image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<String> mSelectPath = (ArrayList<String>) bundle.getSerializable("image");
        String position = intent.getStringExtra("position");
        StringBuilder sb = new StringBuilder();
        image=new ArrayList<>();
        for(String p: mSelectPath){
            sb.append(p);
            sb.append("\n");
            Bitmap bitmap = BitmapUtil.getScaleBitmap(p, 0, 0);
            image.add(bitmap);
        }

        ViewPager viewPager = findViewById(R.id.viewPage);
        viewPager.setAdapter(new ViewPageAdapter(image));


//        gallery =  findViewById(R.id.pic_gallery);
//
//        gallery.setVerticalFadingEdgeEnabled(false);// 取消竖直渐变边框
//        gallery.setHorizontalFadingEdgeEnabled(false);// 取消水平渐变边框
//        gallery.setDetector(new GestureDetector(this,
//                new MySimpleGesture()));
//        initViews();
//        mAdapter = new GalleryAdapter(ImageActivity.this,image,Integer.parseInt(position));
//        gallery.setAdapter(mAdapter);
//        gallery.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//                return false;
//            }
//        });
//        mAdapter.getPositionListener(new GalleryAdapter.GalleryPositionListener() {
//            @Override
//            public void movePosition(int index) {
//                Log.d("helpTopicImage--> ", " " + index);
//            }
//        });

    }
    private void initViews() {

        screenWidth = getWindow().getWindowManager().getDefaultDisplay()
                .getWidth();
        screenHeight = getWindow().getWindowManager().getDefaultDisplay()
                .getHeight();

    }

    private class MySimpleGesture extends GestureDetector.SimpleOnGestureListener {
        // 按两下的第二下Touch down时触发
        @Override
        public boolean onDoubleTap(MotionEvent e) {

            View view = gallery.getSelectedView();
            if (view instanceof MyImageView) {
                MyImageView imageView = (MyImageView) view;
                if (imageView.getScale() > imageView.getMiniZoom()) {
                    imageView.zoomTo(imageView.getMiniZoom());
                } else {
                    imageView.zoomTo(imageView.getMaxZoom());
                }

            } else {

            }
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            // Logger.LOG("onSingleTapConfirmed",
            // "onSingleTapConfirmed excute");
            // mTweetShow = !mTweetShow;
            // tweetLayout.setVisibility(mTweetShow ? View.VISIBLE
            // : View.INVISIBLE);
            return true;
        }
    }

}
