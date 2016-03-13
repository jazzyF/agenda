package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.NOT_FOUND;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.route;
import static play.test.Helpers.running;

import org.junit.Test;

import models.Contact;
import play.mvc.Result;

public class AgendaTest {

	@Test
	public void testListAsAction() {
		running(play.test.Helpers.fakeApplication(), new Runnable() {
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

	@Test
	public void testNewContactRoute() {
		running(play.test.Helpers.fakeApplication(), new Runnable() {
			@Override
			public void run() {
				assertEquals(route(fakeRequest(GET, "/contact/new")).status(), OK);
			}
		});
	}

	@Test
	public void testInvalidRoute() {
		running(play.test.Helpers.fakeApplication(), new Runnable() {
			@Override
			public void run() {
				assertEquals(route(fakeRequest(GET, "/abracada/bra")).status(), NOT_FOUND);
			}
		});
	}

}
