package dev.zilioti.virtualstore.dao;

import dev.zilioti.virtualstore.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ClientDAO {

    @PersistenceContext(unitName = "virtualstore")
    transient private EntityManager entityManager;

    public Client getClientById(Integer id) throws NoResultException {
        //Client client = entityManager.find(Client.class, id);
        Query q = entityManager.createNativeQuery("select idclient, name from client where idclient = ?1", Client.class);
        q.setParameter(1, id);
        return (Client) q.getSingleResult();
    }

    public List<Client> getAllCLients(){
        Query q = entityManager.createNativeQuery("select idclient, name from client", Client.class);
        return q.getResultList();
    }
    public void saveClient(Client client){
        entityManager.persist(client);
    }

}


