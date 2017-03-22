package com.icluj;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by g on 05.03.2017.
 */
@Entity
@Table(name="event")
public class Event {
    @Id
    @NotNull
    private Integer id;


    @NotNull
    public String name;


    @NotNull
    public String description;


    @NotNull
    private Location location;


    @NotNull
    public int iCoins;


    @NotNull
    public String imageUrl;


    @NotNull
    public int color;


    public Integer getId(){return id;}
    public void setId(Integer id){
        this.id=id;
    }
    public String getName(){return name;}
    public void setName(String name){
        this.name=name;

    }
    public String getDescription(){return description;}
    public void setDescription(String description){
        this.description=description;
    }
    @ManyToOne
    public Location getLocation(){return location;}
    public void setLocation(Location location){
        this.location=location;
    }
    public int getiCoins(){return  iCoins;}
    public void setiCoins(int iCoins){
        this.iCoins=iCoins;
    }
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String imageUrl){
        this.imageUrl=imageUrl;
    }
    public int getColor(){return color;}
    public void setColor(int color){
        this.color=color;
    }
}
