package idmexico.com.mx.nasaapi;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.Data.ApodService;
import idmexico.com.mx.nasaapi.Data.Data;
import idmexico.com.mx.nasaapi.model.Mars;
import idmexico.com.mx.nasaapi.ui.view.apod.list.adapter.NasaApodAdapter;
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

        ApodService apodServicePhoto = Data.getRetrofitInstance().create(ApodService.class);
        Call<Mars> callPhotoService = apodServicePhoto.getPhotoWithQuery(1001,"avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");

        callPhotoService.enqueue(new Callback<Mars>() {
            @Override
            public void onResponse(Call<Mars> call, Response<Mars> response) {

                marsRoverListingRecycler.setAdapter(new NasaApodAdapter(response.body().getPhotos()));
            }

            @Override
            public void onFailure(Call<Mars> call, Throwable t) {

            }
        });


    }
}
