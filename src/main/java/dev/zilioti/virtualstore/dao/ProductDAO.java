package dev.zilioti.virtualstore.dao;

import dev.zilioti.virtualstore.model.Client;
import dev.zilioti.virtualstore.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductDAO {

    @PersistenceContext(unitName = "virtualstore")
    transient private EntityManager entityManager;

    public Product getProductById(Integer id) throws NoResultException {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    public List<Product> getAllProducts(){
        Query q = entityManager.createNativeQuery("select * from product", Product.class);
        return q.getResultList();
    }
    public void saveProduct(Product product){
        entityManager.persist(product);
    }


}
