/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.HibernateUtil;
import com.entity.Client;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Clientmodel {
 
        public void create(Client c){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
    
     public void update(Client c){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }
     
     public void delete(Client c){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }
     
    public Client findById(Integer id){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Client c = (Client)ss.get(Client.class, id);
        ss.close();
        return c;
    }
  
    public List<Client> findAll(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Query qry = ss.createQuery("select c from Client c");
       
        List<Client> list = qry.list();
        ss.close();
        return list;
    }
    
}
