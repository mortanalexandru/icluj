package com.icluj;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by g on 05.03.2017.
 */
@Entity
@Table(name="location")
public class Location {
    @Id
    @NotNull
    private Integer id;

    @NotNull
    public String name;


    @NotNull
    public BigDecimal longitude;


    @NotNull
    public BigDecimal latitude;


    @NotNull
    public String address;


    public int getId(){return id;}
    public void setId(int id){
        this.id=id;
    }

    public String getName(){return name;}
    public void setName(String name){
        this.name=name;
    }

    public BigDecimal getLongitude(){return longitude;}
    public void setLongitude(BigDecimal longitude){
        this.longitude=longitude;
    }

    public BigDecimal getLatitude(){return latitude;}
    public void setLatitude(BigDecimal latitude){
        this.latitude=latitude;
    }

    public String getAddress(){return address;}
    public void setAddress(String address){
        this.address = address;
    }

}
