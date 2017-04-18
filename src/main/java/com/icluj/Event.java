package com.icluj;

import java.util.Set;

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
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "events")
    private Set<User> users;


    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private Location location;
    

    @NotNull
    public int iCoins;


    @NotNull
    public String imageUrl;


    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "color")
    public Color color;


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
    public Color getColor(){return color;}
    public void setColor(Color color){
        this.color=color;
    }
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
    
}
