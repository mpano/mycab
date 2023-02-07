/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.websocket;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

/**
 *
 * @author mpano
 */
public class EchoEndPoint extends Endpoint{

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private static class EchoMessage implements MessageHandler.Whole<String>{

        private final RemoteEndpoint.Basic remoteEndpointBasic;

        public EchoMessage(RemoteEndpoint.Basic remoteEndpointBasic) {
            this.remoteEndpointBasic= remoteEndpointBasic;
        }
        
        

        @Override
        public void onMessage(String message) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
