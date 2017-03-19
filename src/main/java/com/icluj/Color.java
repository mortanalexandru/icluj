package com.icluj;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by g on 05.03.2017.
 */
@Entity
@Table(name="color")
public class Color {
    @Id
    @NotNull
    private int id;


    @NotNull
    public String color;


    @NotNull
    public String type;

    public int getId(){return id;}
    public void setId(int id){
        this.id=id;
    }
    public String getColor(){return color;}
    public void setColor(String color){
        this.color=color;
    }
    public String getType(){return type;}
    public void setType(String type){
        this.type=type;
    }
}
