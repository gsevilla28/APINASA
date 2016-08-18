package idmexico.com.mx.nasaapi.ui.view.apod.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import idmexico.com.mx.nasaapi.R;
import idmexico.com.mx.nasaapi.model.APOD;


/**
 * Created by Administrator on 18/08/2016.
 */
public class FavoritesAdapter extends RecyclerView.Adapter<FavoriteHolder> {
    public FavoritesAdapter(){}

    private List<APOD> apodList;

    @Override
    public FavoriteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavoriteHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_item,parent,false));
    }


    @Override
    public void onBindViewHolder(FavoriteHolder holder, int position) {
        APOD apod = apodList.get(position);

        //Picasso.with(holder.itemApodImage.getContext()).load(photo.getImgSrc()).into(holder.itemApodImage); /*utilizando picasso*/
        holder.imageFavorite.setImageURI(apod.getUrl()); /*utilizando fresco*/
        holder.title_favorite.setText(apod.getTitle());

    }

    @Override
    public int getItemCount() {
        return  apodList != null ? apodList.size() :0; /*este metodo indica cuantos elementos se van a mostrar en la vista, nunca debe estar en cero de lo contrario no mostrará nada*/
    }
    public void setListAPOD(List<APOD> marsAPOD){
        this.apodList=marsAPOD;
    }
}
