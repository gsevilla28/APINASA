package idmexico.com.mx.nasaapi.ui.view.apod.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;
import idmexico.com.mx.nasaapi.R;
import idmexico.com.mx.nasaapi.model.APOD;

/**
 * Created by Administrator on 18/08/2016.
 */
public class FavoriteHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_image_favorite)/*vista nasa apod item*/
            SimpleDraweeView imageFavorite;

    @BindView(R.id.item_title_favorite)
    TextView title_favorite;

    private FavoritesAdapter.OnItemClickListener onItemClickListener;
    private APOD apod;

    public FavoriteHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }
    public void setItemClick(APOD apod ,FavoritesAdapter.OnItemClickListener onItemClickListener ){
        this.apod=apod;
        this.onItemClickListener=onItemClickListener;
    }


    @OnClick(R.id.item_image_favorite)
    public void onViewClick(View view){
        if(onItemClickListener !=null)
            onItemClickListener.onItemClick(apod);
    }

}
