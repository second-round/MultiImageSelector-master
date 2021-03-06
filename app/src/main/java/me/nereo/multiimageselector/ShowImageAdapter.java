package me.nereo.multiimageselector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by admin
 * 2019/4/29
 * 所有订单适配器
 */
public class ShowImageAdapter extends RecyclerView.Adapter<ShowImageAdapter.ViewHolder> {

    private List<Bitmap> imageList;

    private Context context;


    public ShowImageAdapter(List<Bitmap> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    public void showImage(List<Bitmap> imageList) {
        this.imageList = imageList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder viewHolder;
        View view= LayoutInflater.from(context).inflate(R.layout.item_showimage, null);
        viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
//        if (imageList.size()==0){
//            Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),R.mipmap.iv_add);
//            viewHolder.imageView.setImageBitmap(bitmap);
//            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    onIntentClick.item();
//                }
//            });
//        }else {
//            if (imageList.size()==(i)){
//                if (imageList.size()==9){
//                    viewHolder.imageView.setVisibility(View.GONE);
//                }else {
//                    Bitmap bitmap= BitmapFactory.decodeResource(context.getResources(),R.mipmap.iv_add);
//                    viewHolder.imageView.setImageBitmap(bitmap);
//                    viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            onIntentClick.item();
//                        }
//                    });
//                }
//            }else {
//
//            }
            viewHolder.imageView.setImageBitmap(imageList.get(i));
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClick.item(i);
                }
            });
        }
//    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
        }
    }

    private OnClick onClick;
    public void setdeleteClick(OnClick onClick) {
        this.onClick = onClick;
    }
    public interface OnClick{
        void item(int posttion);
    }

    private OnIntentClick onIntentClick;
    public void setaddClick(OnIntentClick onClick) {
        this.onIntentClick = onClick;
    }
    public interface OnIntentClick{
        void item();
    }



}

