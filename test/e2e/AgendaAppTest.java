package e2e;

import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import org.junit.Test;

import play.libs.ws.WS;
import play.mvc.Http.Response;

public class AgendaAppTest {

	@Test
	public void testNewContentForPage() {
		running(testServer(3333), new Runnable() {
			@Override
			public void run() {
				//WS.newClient(3333).url("http://localhost:3333/contact/new").get();
				//Response response = WS.newClient(3333).url("http://localhost:3333/contact/new").get().
						//url("http://localhost:3333/contact/new", play.test.Helpers.fakeApplication()).get().await().get();
			}
		});
	}
	
}
