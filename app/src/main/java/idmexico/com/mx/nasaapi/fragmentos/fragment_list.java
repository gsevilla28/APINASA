package idmexico.com.mx.nasaapi.fragmentos;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
                //Picasso.with(getApplicationContext()).load(response.body().getPhotos().get(1).getImgSrc()).into(image);

            }

            @Override
            public void onFailure(Call<APOD> call, Throwable t) {

            }
        });




        return  view;
    }


}
