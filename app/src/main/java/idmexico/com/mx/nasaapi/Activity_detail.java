package idmexico.com.mx.nasaapi;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.model.Photo;
import idmexico.com.mx.nasaapi.util.Comunicador;

/**
 * Created by Alumno on 06/08/2016.
 */
public class Activity_detail extends AppCompatActivity {

    @BindView(R.id.txttitulo_detail)
        TextView tituloDetalle;
    @BindView(R.id.txtfecha_detail)
        TextView FechaDetalle;
    @BindView(R.id.txtexplicacion_detail)
        TextView txtexplicacion_detail;
    @BindView(R.id.txtcamera_detail)
        TextView cameraDetail;
    @BindView(R.id.image_detail)
        ImageView imagen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);


        //Photo Photodatos = (Photo) Comunicador.getObject();
        Photo Photodatos = (Photo) getIntent().getExtras().getSerializable("parametro");

        tituloDetalle.setText("Id foto: " + String.valueOf(Photodatos.getId()));
        FechaDetalle.setText("fecha: " + Photodatos.getEarthDate());
        txtexplicacion_detail.setText(String.valueOf(Photodatos.getSol()));

        Picasso.with(this).load(Photodatos.getImgSrc()).into(imagen);


    }
}
