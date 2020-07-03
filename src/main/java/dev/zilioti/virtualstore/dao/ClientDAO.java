package dev.zilioti.virtualstore.dao;

import dev.zilioti.virtualstore.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ClientDAO {

    @PersistenceContext(unitName = "virtualstore")
    transient private EntityManager entityManager;

    public Client getClientById(Integer id) {
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    public List<Client> getAllCLients(){
        Query q = entityManager.createNativeQuery("select * from client", Client.class);
        return q.getResultList();
    }
    public void saveClient(Client client){
        entityManager.persist(client);
    }

}


