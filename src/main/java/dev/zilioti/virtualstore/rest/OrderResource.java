package dev.zilioti.virtualstore.rest;


import dev.zilioti.virtualstore.config.Secured;
import dev.zilioti.virtualstore.dao.OrderDAO;
import dev.zilioti.virtualstore.model.Order;
import dev.zilioti.virtualstore.response.GenericResponse;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("orders")
@Produces("application/json")
public class OrderResource {

    @Inject
    private OrderDAO orderDAO;

    @GET
    public Response getAll() {
        List<Order> orderList = new ArrayList<Order>();
        orderList = orderDAO.getAllOrders();
        orderList.stream().forEach(order -> order.getClient().cleanPassword());
        return Response.status(200).entity(orderList).build();
    }

    @GET
    @Path("{id}")
    public Response getOrder(@PathParam("id") Integer id) {
        try{
            Order order = orderDAO.getOrderById(id);
            order.getClient().cleanPassword();
            return Response.status(200).entity(order).build();
        }catch(NoResultException e){
            return Response.status(Response.Status.NOT_FOUND).entity(new GenericResponse("error","order not found")).build();
        }
    }

    @POST
    @Secured
    public Response saveOrder(Order order){
        if(order.getDate() == null || order.getClient() == null || order. getProducts() == null){
            return Response.status(Response.Status.BAD_REQUEST).entity(new GenericResponse("error", "parameter missing in the request")).build();
        }
        orderDAO.saveOrder(order);
        return Response.status(201).build();
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }
}
