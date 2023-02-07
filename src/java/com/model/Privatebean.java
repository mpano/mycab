/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.dao.Privateclientdao;
import com.entity.PrivateClient;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mpano
 */
@ManagedBean(name="pcl")
@SessionScoped
public class Privatebean {
     private String car="";
    private PrivateClient privateClient = new PrivateClient();
     private Privateclientdao pcd=new Privateclientdao();
     
     public String getCar() {
        return car;
    }

    public PrivateClient getPrivateClient() {
        return privateClient;
    }

    public void setPrivateClient(PrivateClient privateClient) {
        this.privateClient = privateClient;
    }

    
    public void setCar(String car) {
        this.car = car;
    }
    
     public String benz(){
       
        car = "mercedes benz";
        return "privatebooking";
    }
     public String bmw(){
        
        car = "BMW black 2023";
        privateClient.setCar(car);
        return "privatebooking?faces-redirect=true";
    }
     public String rolls(){
        car = "Rolls Royce";
        privateClient.setCar(car);
        return "privatebooking?faces-redirect=true";
    }
    
        public String saveprivate(){
        
       pcd.create(privateClient);
       addMessage("Hello  "+privateClient.getFname()+"   you have saved your private booking successfully","");
       return "viewBookings";
    }
       public List<PrivateClient> getAllBookings(){
          return pcd.findAll();
          } 
     public String delete(PrivateClient c){
         int i=c.getId();
         pcd.delete(c);
         return null;
     }  
       
         public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
