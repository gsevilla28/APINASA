package idmexico.com.mx.nasaapi.util;

import java.util.Objects;

/**
 * Created by Alumno on 06/08/2016.
 */
public class Comunicador {

    private static Object object=null;

    public static void SetObjet(Object objeto){
        object=objeto;
    }
    public static Object getObject(){
        return object;
    }
}
