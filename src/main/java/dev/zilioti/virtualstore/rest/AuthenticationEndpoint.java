package dev.zilioti.virtualstore.rest;

import dev.zilioti.virtualstore.dao.ClientDAO;
import dev.zilioti.virtualstore.model.Client;
import dev.zilioti.virtualstore.model.UserAuthentication;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("authentication")
@Produces("application/json")
public class AuthenticationEndpoint {

    @Inject
    ClientDAO clientDAO;

    @POST
    public Response authenticateUser(Client client) {

        String username = client.getName();
        String password = client.getPassword();

        try {

            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(String username, String password) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        Client client = clientDAO.findByName(username);
        if(!client.getPassword().equals(password)){
            throw new Exception();
        }
    }

    private String issueToken(String username) {
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
        String token = username + UUID.randomUUID();
        UserAuthentication userAuthentication = new UserAuthentication(username, token);
        clientDAO.saveToken(userAuthentication);
        return token;
    }

    public ClientDAO getClientDAO() {
        return clientDAO;
    }

    public void setClientDAO(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
}
