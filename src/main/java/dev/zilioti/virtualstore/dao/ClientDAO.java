package dev.zilioti.virtualstore.dao;

import dev.zilioti.virtualstore.model.Client;
import dev.zilioti.virtualstore.model.UserAuthentication;

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
        Client client = entityManager.find(Client.class, id);
//        Query q = entityManager.createNativeQuery("select * from client where idclient = ?1", Client.class);
//        q.setParameter(1, id);
        return client;
    }

    public Client findByName(String name){
        Query q = entityManager.createNativeQuery("select * from client where name = ?1", Client.class);
        q.setParameter(1, name);
        return (Client) q.getSingleResult();
    }

    public List<Client> getAllCLients(){
        Query q = entityManager.createNativeQuery("select * from client", Client.class);
        return q.getResultList();
    }
    public void saveClient(Client client){
        entityManager.persist(client);
    }

    public void saveToken(UserAuthentication userAuthentication){
        try{
            Query q = entityManager.createNativeQuery("select * from user_authetication where name_user = ?1", UserAuthentication.class);
            q.setParameter(1, userAuthentication.getName_user());
            UserAuthentication oldAuth = (UserAuthentication) q.getSingleResult();
            userAuthentication.setId(oldAuth.getId());
            entityManager.merge(userAuthentication);
        }catch (NoResultException e){
            entityManager.persist(userAuthentication);
        }
    }

    public UserAuthentication findByToken(String token) throws NoResultException{
        Query q = entityManager.createNativeQuery("select * from user_authetication where token = ?1", UserAuthentication.class);
        q.setParameter(1, token);
        return (UserAuthentication) q.getSingleResult();
    }

}


