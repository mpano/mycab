/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.HibernateUtil;
import com.entity.Client;
import com.entity.PrivateClient;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class Privateclientdao {
 
        public void create(PrivateClient c){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.save(c);
        ss.getTransaction().commit();
        ss.close();
    }
    
     public void update(PrivateClient c){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.update(c);
        ss.getTransaction().commit();
        ss.close();
    }
     
     public void delete(PrivateClient c){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        ss.beginTransaction();
        ss.delete(c);
        ss.getTransaction().commit();
        ss.close();
    }
  
    public List<PrivateClient> findAll(){
        Session ss = HibernateUtil.getSessionFactory().openSession();
        Query qry = ss.createQuery("select c from PrivateClient c");
       
        List<PrivateClient> list = qry.list();
        ss.close();
        return list;
    }
    
}
