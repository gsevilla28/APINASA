package idmexico.com.mx.nasaapi.model;

/**
 * Created by Alumno on 05/08/2016.
 */



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Camera_ implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_name")
    @Expose
    private String fullName;

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     * The full_name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}