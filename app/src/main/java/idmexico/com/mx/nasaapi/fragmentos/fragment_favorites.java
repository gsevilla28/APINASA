package idmexico.com.mx.nasaapi.fragmentos;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.R;
import idmexico.com.mx.nasaapi.model.APOD;
import idmexico.com.mx.nasaapi.model.Photo;
import idmexico.com.mx.nasaapi.sql.DataSource;
import idmexico.com.mx.nasaapi.ui.view.apod.list.adapter.FavoritesAdapter;
import idmexico.com.mx.nasaapi.ui.view.apod.list.adapter.NasaApodAdapter;

/**
 * Created by Administrator on 18/08/2016.
 */
public class fragment_favorites extends Fragment {

    @BindView(R.id.mar_rover_listing)
    RecyclerView vistaReciclada;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_listing,container,false);
        ButterKnife.bind(this,view);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        vistaReciclada.setLayoutManager(gridLayoutManager);
        final FavoritesAdapter favoritesAdapter = new FavoritesAdapter();

        /*obtener lista de favoritos*/
        DataSource dataSource = new DataSource(getActivity());

        ArrayList<APOD> listafavoritos = (ArrayList<APOD>) dataSource.getAllFavorites();

        favoritesAdapter.setListAPOD(listafavoritos);
        vistaReciclada.setAdapter(favoritesAdapter);

        return view;
    }
}
