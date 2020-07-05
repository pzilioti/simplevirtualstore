package dev.zilioti.virtualstore.dao;

import dev.zilioti.virtualstore.model.Order;
import dev.zilioti.virtualstore.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class OrderDAO {

    @PersistenceContext(unitName = "virtualstore")
    transient private EntityManager entityManager;

    public Order getOrderById(Integer id) throws NoResultException {
        Order order = entityManager.find(Order.class, id);
        return order;
    }

    public List<Order> getAllOrders(){
        Query q = entityManager.createNativeQuery("select * from order_store", Order.class);
        return q.getResultList();
    }
    public void saveOrder(Order order){
        entityManager.persist(order);
    }


}
