package dev.zilioti.virtualstore.test;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientTest {
    @Test
    public void testGetAllClients() throws Exception {
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://localhost:8080/virtualstore/rest")
                .path("clients")
                .request()
                .get();

        assertNotNull(response);
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void testGetClient() throws Exception {
        Client client = ClientBuilder.newClient();

        Response response = client.target("http://localhost:8080/virtualstore/rest/clients")
                .path("{id}")
                .resolveTemplate("id", 1)
                .request()
                .get();


        assertNotNull(response);
        assertEquals(response.getStatus(), 200);
    }
}

