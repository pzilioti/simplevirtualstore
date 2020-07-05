package dev.zilioti.virtualstore.rest;

import dev.zilioti.virtualstore.dao.ProductDAO;
import dev.zilioti.virtualstore.model.Client;
import dev.zilioti.virtualstore.model.Product;
import dev.zilioti.virtualstore.response.GenericResponse;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("products")
@Produces("application/json")
public class ProductResource {

    @Inject
    ProductDAO productDAO;

    @GET
    public Response getAll() {
        List<Product> productList;
        productList = productDAO.getAllProducts();
        return Response.status(200).entity(productList).build();
    }

    @GET
    @Path("{id}")
    public Response getProduct(@PathParam("id") Integer id) {
        try{
            Product product = productDAO.getProductById(id);
            return Response.status(200).entity(product).build();
        }catch(NoResultException e){
            return Response.status(Response.Status.NOT_FOUND).entity(new GenericResponse("error","product not found")).build();
        }

    }

    @POST
    public Response saveProduct(Product product){
        if(product.getName() == null || product.getDescription() == null || product.getPrice() == null){
            return Response.status(Response.Status.BAD_REQUEST).entity(new GenericResponse("error", "parameter missing in the request")).build();
        }
        productDAO.saveProduct(product);
        return Response.status(201).build();
    }


}
