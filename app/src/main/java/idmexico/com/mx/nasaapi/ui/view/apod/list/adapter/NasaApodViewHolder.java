package idmexico.com.mx.nasaapi.ui.view.apod.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import idmexico.com.mx.nasaapi.R;
import idmexico.com.mx.nasaapi.model.Photo;

/**
 * Created by Alumno on 05/08/2016.
 */
public class NasaApodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_apod_image)/*vista nasa apod item*/
            SimpleDraweeView itemApodImage;

    @BindView(R.id.item_apod_text)
            TextView item_apod_title;

    private Photo photo;
    private NasaApodAdapter.OnItemClickListener onItemClickListener;


    public NasaApodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setItemClick(Photo photo,NasaApodAdapter.OnItemClickListener onItemClickListener){
        this.photo=photo;
        this.onItemClickListener=onItemClickListener;
    }
    @OnClick(R.id.item_apod_image)
    public void onViewClick(View view){
        if(onItemClickListener !=null)
            onItemClickListener.onItemClick(photo);
    }
}
