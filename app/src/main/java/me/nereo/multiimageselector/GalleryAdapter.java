package me.nereo.multiimageselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class GalleryAdapter extends BaseAdapter {

    private Context context;

    private ArrayList<MyImageView> imageViews = new ArrayList<MyImageView>();

    private GalleryPositionListener positionListener;
    private int position = 0;
    private ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            Bundle bundle = msg.getData();
            String url = bundle.getString("url");
            for (int i = 0; i < imageViews.size(); i++) {
                if (imageViews.get(i).getTag().equals(url)) {
                    imageViews.get(i).setImageBitmap(bitmap);
                }
            }
        }
    };

    public void setData(List<Integer> data) {
        notifyDataSetChanged();
    }

    public GalleryAdapter(Context context,ArrayList<Bitmap>  helpTopicImage,int position) {
        this.context = context;
        this.bitmaps = helpTopicImage;
        this.position = position;
    }

    @Override
    public int getCount() {
        return bitmaps.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyImageView view = new MyImageView(context);
        view.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));

        if (bitmaps.get(position) != null) {
            view.setImageBitmap(bitmaps.get(position));
        }
        if (!this.imageViews.contains(view)) {
            imageViews.add(view);
        }
        positionListener.movePosition(position);
        return view;
    }

    public void getPositionListener(GalleryPositionListener positionListener) {
        this.positionListener = positionListener;
    }

    public interface GalleryPositionListener{
        public void movePosition(int index);
    }
}