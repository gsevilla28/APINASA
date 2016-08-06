package idmexico.com.mx.nasaapi.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Alumno on 06/08/2016.
 * controla el ciclo de vida de la aplicacion, se declara en manifest
 */
public class NasaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
