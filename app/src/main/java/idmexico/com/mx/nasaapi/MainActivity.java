package idmexico.com.mx.nasaapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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

        //Log.d("Hola",BuildConfig.URL);

        ApodService apodService = Data.getRetrofitInstance().create(ApodService.class);
        //Call<APOD> callApodService = apodService.getTodayApod(); /*ejmplo con parametro directo*/

        /*llamada al WS enviando parametros dinamicos*/
        Call<APOD> callApodService = apodService.getTodayApodWithQuery("avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z");

        callApodService.enqueue(new Callback<APOD>() {
            @Override
            public void onResponse(Call<APOD> call, Response<APOD> response) {
                Log.d("APOD", response.body().getTitle());
            }

            @Override
            public void onFailure(Call<APOD> call, Throwable t) {

            }
        });



    }
}
