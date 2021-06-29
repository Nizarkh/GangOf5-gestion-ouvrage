package com.Gangof5.ecommerce.dto.user;

import java.util.Date;

import javax.persistence.Column;

import com.Gangof5.ecommerce.enums.Gender;
import com.Gangof5.ecommerce.enums.Role;

public class UserUpdateDto {
    // skipping updating passord as of now
    private Integer id;
    private String firstName;
    private String lastName;
   // private Role role;
    private String password;
    private String address;
	private Gender gender;
	private String country;
	private Date birthday;
    


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

   /* public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }*/
	
	
}
