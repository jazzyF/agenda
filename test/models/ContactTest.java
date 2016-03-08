package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.running;

import org.junit.Test;

public class ContactTest {

	@Test
	public void testContactModel() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			@Override
			public void run() {
				String name = "Mike";
				String email = "email@nobody.com";
				String phone = "1234";
				Contact contact = new Contact(name, email, phone);

				contact.save();

				Contact savedContact = Contact.find.byId(contact.id);

				assertNotNull(savedContact);
				assertEquals(name, savedContact.name);
				assertEquals(email, savedContact.email);
				assertEquals(phone, savedContact.phone);
			}
		});
	}

}
