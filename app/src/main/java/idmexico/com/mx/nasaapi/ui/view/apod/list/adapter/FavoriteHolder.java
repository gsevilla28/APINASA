package idmexico.com.mx.nasaapi.ui.view.apod.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.R;

/**
 * Created by Administrator on 18/08/2016.
 */
public class FavoriteHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_image_favorite)/*vista nasa apod item*/
            SimpleDraweeView imageFavorite;

    @BindView(R.id.item_title_favorite)
    TextView title_favorite;

    public FavoriteHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }


}
