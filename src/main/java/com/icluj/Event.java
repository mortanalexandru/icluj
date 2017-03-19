package com.icluj;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by g on 05.03.2017.
 */
@Entity
@Table(name="event")
public class Event {
    @Id
    @NotNull
    private int id;


    @NotNull
    public String name;


    @NotNull
    public String description;


    @NotNull
    public int location;


    @NotNull
    public int iCoins;


    @NotNull
    public String imageUrl;


    @NotNull
    public int color;


    public int getId(){return id;}
    public void setId(int id){
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
    public int getLocation(){return location;}
    public void setLocation(int location){
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
