package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.route;
import static play.test.Helpers.running;

import org.junit.Test;

import models.Contact;
import play.mvc.Result;

public class AgendaTest {

	@Test
	public void test() {
		running(fakeApplication(inMemoryDatabase()), new Runnable() {
			@Override
			public void run() {
				String name = "Jack";
				String email = "jack@nobody.com";
				String phone = "42321";
				Contact contact = new Contact(name, email, phone);

				contact.save();

				Result result = route(controllers.routes.Agenda.list());

				assertEquals(OK, result.status());
				assertEquals(result.contentType().get(), "text/html");
				assertTrue(contentAsString(result).contains(contact.name));
			}
		});
	}

}
