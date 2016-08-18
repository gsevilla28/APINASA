package idmexico.com.mx.nasaapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.picasso.Picasso;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import idmexico.com.mx.nasaapi.fragmentos.fragment_favorites;
import idmexico.com.mx.nasaapi.model.Photo;
import idmexico.com.mx.nasaapi.sql.DataSource;


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
    @BindView(R.id.toolbar_activity_detail)
        Toolbar toolbar;

    private String img;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("view Detail");




        //Photo Photodatos = (Photo) Comunicador.getObject();
        Photo Photodatos = (Photo) getIntent().getExtras().getSerializable("parametro");

        tituloDetalle.setText("Id foto: " + String.valueOf(Photodatos.getId()));
        FechaDetalle.setText("fecha: " + Photodatos.getEarthDate());
        txtexplicacion_detail.setText(String.valueOf(Photodatos.getSol()));

        Picasso.with(this).load(Photodatos.getImgSrc()).into(imagen);
        img = Photodatos.getImgSrc().toString();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_detail_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.add_favorites_menu:
                saveinBD();
        }

        return true;
    }

    private void saveinBD() {
        DataSource dataSource = new DataSource(this);
        long guardar = dataSource.SaveFavorite(tituloDetalle.getText().toString(),txtexplicacion_detail.getText().toString(),FechaDetalle.getText().toString(),img);

        Snackbar.make(findViewById(android.R.id.content),"Agregado a Favoritos",Snackbar.LENGTH_SHORT).setAction("Terminar", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).show();

    }


}
