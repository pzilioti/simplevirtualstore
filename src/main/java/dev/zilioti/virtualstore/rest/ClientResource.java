package dev.zilioti.virtualstore.rest;

import dev.zilioti.virtualstore.dao.ClientDAO;
import dev.zilioti.virtualstore.model.Client;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;


@Path("clients")
@Produces("application/json")
public class ClientResource {

    @Inject
    ClientDAO clientDAO;

    @GET
    public Response getAll() {
        List<Client> clientList = new ArrayList<Client>();
        clientList = clientDAO.getAllCLients();
        return Response.status(200).entity(clientList).build();
    }

    @GET
    @Path("{id}")
    public Response getApplication(@PathParam("id") Integer id) {
        Client client = clientDAO.getClientById(id);
        return Response.status(200).entity(client).build();
    }

    @POST
    public Response saveClient(Client client){
        clientDAO.saveClient(client);
        return Response.status(201).build();
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}