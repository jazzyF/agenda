package views;

import static org.junit.Assert.assertTrue;
import static play.test.Helpers.contentAsString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import models.Contact;
import play.twirl.api.Html;

public class ListTemplateTest {

	@Test
	public void testTemplate() {
		String name = "Bob";
		String email = "bob@nobody.com";
		String phone = "45678";
		Contact contact = new Contact();
		contact.name = name;
		contact.email = email;
		contact.phone = phone;
		List<Contact> contacts = new ArrayList<>();
		contacts.add(contact);
		Html content = views.html.list.render(contacts);

		assertTrue("text/html".equals(content.contentType()));
		assertTrue(contentAsString(content).contains(contact.name));
		assertTrue(contentAsString(content).contains("Create a new contact"));
	}
}
