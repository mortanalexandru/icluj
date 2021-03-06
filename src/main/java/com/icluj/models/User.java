package com.icluj.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



/**
 * Created by Alexandru on 31/01/2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @NotNull
    private String email;

    @NotNull
    private String password;

    private String nickname;
    
    private int iCoins;
    
    private String imageUrl;
    
    private Date date_of_birth;
   
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_event", joinColumns = {
			@JoinColumn(name = "user", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "event",
					nullable = false, updatable = false) })
    private Set<Event> events;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public int getiCoins() {
		return iCoins;
	}

	public void setiCoins(int iCoins) {
		this.iCoins = iCoins;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
}