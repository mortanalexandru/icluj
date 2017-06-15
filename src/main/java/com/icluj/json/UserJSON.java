package com.icluj.json;

/**
 * Created by Alexandru on 03/02/2017.
 */
public class UserJSON {

    private String email;
    private String password;
    private String nickname;
    private String image;
    private DateJSON dob;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DateJSON getDob() {
		return dob;
	}

	public void setDob(DateJSON dob) {
		this.dob = dob;
	}
}
