package idmexico.com.mx.nasaapi;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.fragmentos.fragment_list;
import idmexico.com.mx.nasaapi.fragmentos.fragment_listing;


/**
 * Created by Alumno on 05/08/2016.
 */
public class ListingActivity extends AppCompatActivity {

    //@BindView(R.id.mar_rover_listing) /*id del recicler view el cual es una lay out activity listing.xml*/
     //       RecyclerView marsRoverListingRecycler;

    @BindView(R.id.listing_toolbar)
    Toolbar toolbar;

    @BindView(R.id.design_navigation_view)
    NavigationView navigationView;

    @BindView(R.id.listing_navigation_drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.image_header)
    SimpleDraweeView image;
    @BindView(R.id.text_header)
    TextView texnombre;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_listing);
        setContentView(R.layout.listing_navigation_activity);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();

                switch (item.getItemId()){
                    case R.id.today_apod_item:
                        //Snackbar.make(findViewById(android.R.id.content),"Today Apod item",Snackbar.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.Fragmento_holder, new fragment_list()).commit();

                        break;
                    case R.id.mars_rover__item:
                        //Snackbar.make(findViewById(android.R.id.content),"mars Rover item",Snackbar.LENGTH_SHORT).show();
                        getFragmentManager().beginTransaction().replace(R.id.Fragmento_holder,new fragment_listing()).commit();
                        break;
                    case R.id.favorite_item:
                        Snackbar.make(findViewById(android.R.id.content),"Favorite item",Snackbar.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();







        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
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
        });*/

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }
    /*metodo para obtener datos de facebook*/
    private void getFBuserinfo(){

        GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    //Log.d("nombre",object.getString("name"));

                    image.setImageURI("http://graph.facebook.com/" + object.getString("id") + "/picture?type=large");
                    texnombre.setText(object.getString("name"));

                    //Log.d("id",object.getString("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        graphRequest.executeAsync();

    }

}

