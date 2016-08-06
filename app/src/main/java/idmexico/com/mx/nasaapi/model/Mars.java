package idmexico.com.mx.nasaapi.model;

/**
 * Created by Alumno on 05/08/2016.
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Mars implements Serializable{

    @SerializedName("photos")
    @Expose
    private List<Photo> photos = new ArrayList<Photo>();

    /**
     *
     * @return
     * The photos
     */
    public List<Photo> getPhotos() {
        return photos;
    }

    /**
     *
     * @param photos
     * The photos
     */
    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}