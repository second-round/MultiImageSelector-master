package me.nereo.multiimageselector;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends PagerAdapter {

    private ArrayList<Bitmap> list;

    public ViewPageAdapter(ArrayList<Bitmap> resList) {
        this.list = resList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        MatrixImageView iv = new MatrixImageView(container.getContext(),null);

        iv.setImageBitmap(list.get(position));

        // 添加到ViewPager容器
        container.addView(iv);

        // 返回填充的View对象
        return iv;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}