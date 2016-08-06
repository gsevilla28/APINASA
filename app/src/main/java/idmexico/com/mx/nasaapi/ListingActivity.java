package idmexico.com.mx.nasaapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.Data.ApodService;
import idmexico.com.mx.nasaapi.Data.Data;
import idmexico.com.mx.nasaapi.model.Mars;
import idmexico.com.mx.nasaapi.model.Photo;
import idmexico.com.mx.nasaapi.ui.view.apod.list.adapter.NasaApodAdapter;
import idmexico.com.mx.nasaapi.util.Comunicador;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alumno on 05/08/2016.
 */
public class ListingActivity extends AppCompatActivity{

    @BindView(R.id.mar_rover_listing) /*id del recicler view el cual es una lay out activity listing.xml*/
    RecyclerView marsRoverListingRecycler;



    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);
        ButterKnife.bind(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(10,StaggeredGridLayoutManager.VERTICAL);

        marsRoverListingRecycler.setLayoutManager(gridLayoutManager);

        final NasaApodAdapter nasaApodAdapter = new NasaApodAdapter();
        nasaApodAdapter.setOnItemClickListener(new NasaApodAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Photo photo) {
                //Comunicador.SetObjet(photo);

                Intent intent = new Intent(getApplicationContext(),Activity_detail.class);
                intent.putExtra("parametro",photo);
                startActivity(intent);

            }
        });

        ApodService apodServicePhoto = Data.getRetrofitInstance().create(ApodService.class);
        Call<Mars> callPhotoService = apodServicePhoto.getPhotoWithQuery(1001,"avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");

        callPhotoService.enqueue(new Callback<Mars>() {
            @Override
            public void onResponse(Call<Mars> call, Response<Mars> response) {
                nasaApodAdapter.setMarsPhotos(response.body().getPhotos());
                marsRoverListingRecycler.setAdapter(nasaApodAdapter);

            }

            @Override
            public void onFailure(Call<Mars> call, Throwable t) {

            }
        });

    }
}
