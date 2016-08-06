package idmexico.com.mx.nasaapi.ui.view.apod.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import idmexico.com.mx.nasaapi.R;
import idmexico.com.mx.nasaapi.model.Photo;


/**
 * Created by Alumno on 05/08/2016.
 */
public class NasaApodAdapter extends RecyclerView.Adapter<NasaApodViewHolder> {
    private List<Photo> photoList;
    private OnItemClickListener onItemClickListener;
    public NasaApodAdapter(List<Photo> mars){this.photoList =mars;}

    public NasaApodAdapter(){} /*constructor por default*/





    @Override
    public NasaApodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NasaApodViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.nasa_apod_item,parent,false));
    }

    @Override
    public void onBindViewHolder(NasaApodViewHolder holder, int position) {
        Photo photo = photoList.get(position);

        //Picasso.with(holder.itemApodImage.getContext()).load(photo.getImgSrc()).into(holder.itemApodImage); /*utilizando picasso*/
        holder.itemApodImage.setImageURI(photo.getImgSrc()); /*utilizando fresco*/

        holder.item_apod_title.setText(photo.getEarthDate());

        holder.setItemClick(photo,onItemClickListener); /*enviando parametros*/
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public void setMarsPhotos(List<Photo> marsPhotos){
        this.photoList=marsPhotos;
    }


    @Override
    public int getItemCount() {

        return  photoList != null ? photoList.size() :0; /*este metodo indica cuantos elementos se van a mostrar en la vista, nunca debe estar en cero de lo contrario no mostrará nada*/

    }

    public interface OnItemClickListener{ /*metodo callback*/
        void onItemClick(Photo photo);
    }
}
