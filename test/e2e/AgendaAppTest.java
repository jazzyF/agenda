package e2e;

import static org.junit.Assert.assertTrue;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

import play.libs.ws.WS;

public class AgendaAppTest {

	@Test
	public void testNewContentForPage() {
		running(testServer(3333), new Runnable() {
			@Override
			public void run() {
				try {
					assertTrue(WS.newClient(3333).url("http://localhost:3333/contact/new").get().toCompletableFuture()
							.get().getBody().contains("New contact"));
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
