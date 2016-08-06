package idmexico.com.mx.nasaapi.ui.view.apod.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.R;

/**
 * Created by Alumno on 05/08/2016.
 */
public class NasaApodViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_apod_image)/*vista nasa apod item*/
    ImageView itemApodImage;

    @BindView(R.id.item_apod_text)
    TextView item_apod_title;


    public NasaApodViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
