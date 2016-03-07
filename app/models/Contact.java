package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.avaje.ebean.Model;

@Entity
public class Contact extends Model {

	@Id
	@GeneratedValue
	public Long id;

	public String name;

	public String email;
	
	public String phone;

	public static Finder<Long, Contact> find = new Finder<>(Contact.class);

}
