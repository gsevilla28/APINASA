package idmexico.com.mx.nasaapi.fragmentos;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.Data.ApodService;
import idmexico.com.mx.nasaapi.Data.Data;
import idmexico.com.mx.nasaapi.R;
import idmexico.com.mx.nasaapi.model.APOD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Alumno on 12/08/2016.
 */
public class fragment_list extends Fragment {

    @BindView(R.id.txttitulo)
    TextView txttitulo;
    @BindView(R.id.txtexplicacion) TextView txtexplicacion;
    @BindView(R.id.txtfecha) TextView txtfecha;
    @BindView(R.id.img)
    ImageView image;

    String imageURL;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true); /*para fragmentos se tiene que indicar que hay un menu*/
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main,container,false);
        ButterKnife.bind(this,view);


        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        //Call<APOD> callApodService = apodService.getTodayApod(); /*ejmplo con parametro directo*/

        /*llamada al WS enviando parametros dinamicos*/
        Call<APOD> callApodService = apodService.getTodayApodWithQuery("avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");
        //Call<Mars> callPhotoService = apodService.getPhotoWithQuery(1001,"avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");

        callApodService.enqueue(new Callback<APOD>() {

            @Override
            public void onResponse(Call<APOD> call, Response<APOD> response) {
                //Log.d("APOD", response.body().getTitle());

                txttitulo.setText("Titulo: " + response.body().getTitle());
                //txttitulo.setText("Titulo: " + response.body().getPhotos().get(1).getId());
                txtexplicacion.setText("Explanation: " + response.body().getExplanation());
                txtfecha.setText("Fecha: " + response.body().getDate());
                Picasso.with(getActivity()).load(response.body().getUrl()).into(image);
                imageURL =response.body().getUrl();

            }

            @Override
            public void onFailure(Call<APOD> call, Throwable t) {

            }
        });

        return  view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.apod_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.shared_today_apod:
                //Snackbar.make(getView(),"Agregado a favoritos",Snackbar.LENGTH_SHORT).show();
                shareTex("Compartiendo: " + imageURL );
                break;

        }
        return true;
    }

    /*tulizado para compartir el texto*/
    private void shareTex(String text){
        Intent sharedIntent = new Intent(Intent.ACTION_SEND);
        sharedIntent.setType("text/plain");
        sharedIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(Intent.createChooser(sharedIntent,"Compartir"));

    }

}
