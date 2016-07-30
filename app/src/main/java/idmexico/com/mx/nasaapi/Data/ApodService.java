package idmexico.com.mx.nasaapi.Data;

import idmexico.com.mx.nasaapi.model.APOD;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Alumno on 30/07/2016.
 */
/*esta interface siempre es necesaria para los web services*/
public interface ApodService {
    @GET("planetary/apod?api_key=avBrc43YusSSOaIWiWne5xKSh2qwkC0jN3e6CV1Z")
    Call<APOD> getTodayApod();

    @GET("planetary/apod")
    Call<APOD> getTodayApodWithQuery(@Query("api_key") String api_key);

}
