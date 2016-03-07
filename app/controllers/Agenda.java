package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import models.Contact;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

@Singleton
public class Agenda extends Controller {
	
	public Result list() {
		List<Contact> contacts = Contact.find.all();
		return ok(views.html.list.render(contacts));
	}
	
	public Result show(Long id) {
		Contact contact = Contact.find.byId(id);
		if (contact == null) {
			return notFound();
		} else {
			List<Contact> list = new ArrayList<>();
			list.add(contact);
			return ok(views.html.list.render(list));
		}
	}
	
	public Result newContact() {
		Form<Contact> contactForm = Form.form(Contact.class);
		return ok(views.html.newContact.render(contactForm));
	}
	
	public Result createContact() {
		Form<Contact> contactForm = Form.form(Contact.class).bindFromRequest();
		//form(Contact.class);
		Contact contact = contactForm.get();
		contact.save();
		return redirect(routes.Agenda.list());
		//return ok();
	}

}
