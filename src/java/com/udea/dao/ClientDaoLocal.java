
package com.udea.dao;

import com.udea.model.Client;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ClientDaoLocal {
    
    public void addClient(Client client);
    public void editClient(Client client);
    public void deleteClient(long client);
    public Client getClient(long clientId);
    public List<Client> getAllClient();
}
