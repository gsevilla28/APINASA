package idmexico.com.mx.nasaapi;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import idmexico.com.mx.nasaapi.Data.ApodService;
import idmexico.com.mx.nasaapi.Data.Data;
import idmexico.com.mx.nasaapi.model.APOD;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txttitulo= (TextView) findViewById(R.id.txttitulo);
        final TextView txtexplicacion= (TextView) findViewById(R.id.txtexplicacion);
        final TextView fecha= (TextView) findViewById(R.id.txtfecha);
        final ImageView image = (ImageView) findViewById(R.id.img);

        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        //Call<APOD> callApodService = apodService.getTodayApod(); /*ejmplo con parametro directo*/

        /*llamada al WS enviando parametros dinamicos*/
        Call<APOD> callApodService = apodService.getTodayApodWithQuery("avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");

        callApodService.enqueue(new Callback<APOD>() {
            @Override
            public void onResponse(Call<APOD> call, Response<APOD> response) {
                //Log.d("APOD", response.body().getTitle());


                txttitulo.setText("Titulo: " + response.body().getTitle());
                txtexplicacion.setText("Explanation: " + response.body().getExplanation());
                fecha.setText("Fecha: " + response.body().getDate());
                Picasso.with(getApplicationContext()).load(response.body().getUrl()).into(image);



            }

            @Override
            public void onFailure(Call<APOD> call, Throwable t) {

            }
        });



    }
}
