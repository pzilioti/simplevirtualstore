package dev.zilioti.virtualstore.rest;

import dev.zilioti.virtualstore.model.Client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("clients")
@Produces("application/json")
public class ClientResource {

    @GET
    public List<Client> getAll() {
        ArrayList<Client> testList = new ArrayList<Client>();

        testList.add(new Client(1, "name 1", "pass 1"));
        testList.add(new Client(2, "name 2", "pass 2"));
        testList.add(new Client(3, "name 3", "pass 3"));

        return testList;
    }
}