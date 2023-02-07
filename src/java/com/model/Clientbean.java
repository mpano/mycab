/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.dao.Clientmodel;
import com.dao.Privateclientdao;
import com.entity.Client;
import com.entity.PrivateClient;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "cl")
@SessionScoped
public class Clientbean {
    
    private Client client=new Client();
    private Clientmodel clientmodel=new Clientmodel();
  
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public String save(){
        
       clientmodel.create(client);
       addMessage("Hello "+client.getFname()+" you have saved your booking successfully","");
       return "viewBookings";
        
    }
 
     public String back() {
        return "index.xhtml";
    }
 
     public List<Client> getAllBookings(){
        
        return clientmodel.findAll();
    } 
     public String dele(Client c){
         int i=c.getId();
         clientmodel.delete(c);
         return null;
     }
    
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
    
}
