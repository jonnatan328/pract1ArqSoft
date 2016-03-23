
package com.udea.dao;

import com.udea.model.Client;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ClientDao implements ClientDaoLocal {
    @PersistenceContext(unitName = "Laboratorio1PU")
    private EntityManager em;

    @Override
    public void addClient(Client client) {
         em.persist(client);
    }

    @Override
    public void editClient(Client client) {
         em.merge(client);
    }

    @Override
    public void deleteClient(long clientId) {
        em.remove(getClient(clientId));
    }

    @Override
    public Client getClient(long clientId) {
         return em.find(Client.class, clientId);
    }

    @Override
    public List<Client> getAllClient() {
         return em.createNamedQuery("Client.getAll").getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }

   
}
