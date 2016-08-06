package idmexico.com.mx.nasaapi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.Data.ApodService;
import idmexico.com.mx.nasaapi.Data.Data;
import idmexico.com.mx.nasaapi.model.APOD;
import idmexico.com.mx.nasaapi.model.Mars;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.txttitulo) TextView txttitulo;
    @BindView(R.id.txtexplicacion) TextView txtexplicacion;
    @BindView(R.id.txtfecha) TextView txtfecha;
    @BindView(R.id.img) ImageView image;
    //TextView txttitulo;
    //TextView txtexplicacion;
    //TextView fecha;
    //ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this); /*con esta libreria se elimina el findview y se cambia por las anotaciones @BIND*/



        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        //Call<APOD> callApodService = apodService.getTodayApod(); /*ejmplo con parametro directo*/

        /*llamada al WS enviando parametros dinamicos*/
        //Call<APOD> callApodService = apodService.getTodayApodWithQuery("avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");
        Call<Mars> callPhotoService = apodService.getPhotoWithQuery(1001,"avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");

        //callApodService.enqueue(new Callback<Mars>() {
        callPhotoService.enqueue(new Callback<Mars>() {
            @Override
            public void onResponse(Call<Mars> call, Response<Mars> response) {
                //Log.d("APOD", response.body().getTitle());

                //txttitulo.setText("Titulo: " + response.body().getTitle());
                //txttitulo.setText("Titulo: " + response.body().getPhotos().get(1).getId());
                //txtexplicacion.setText("Explanation: " + response.body().getExplanation());
                //txtfecha.setText("Fecha: " + response.body().getDate());
                Picasso.with(getApplicationContext()).load(response.body().getPhotos().get(1).getImgSrc()).into(image);
                Log.d("holas","asdasd");

            }

            @Override
            public void onFailure(Call<Mars> call, Throwable t) {

            }
        });



    }
}
