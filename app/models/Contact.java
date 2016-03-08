package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Contact extends Model {

	public Contact(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Contact() {
	}

	@Id
	@GeneratedValue
	public Long id;

	public String name;

	public String email;
	
	public String phone;

	public static Finder<Long, Contact> find = new Finder<>(Contact.class);

}
