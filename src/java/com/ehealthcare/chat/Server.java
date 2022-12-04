/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehealthcare.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Percival
 */
public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket serverSocket;
    private boolean done;
    private ExecutorService pool;

    public Server() {
        connections = new ArrayList<>();
        done = false;
    }
    
    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9999);
            pool = Executors.newCachedThreadPool();
            while( !done ) {
            Socket socket = serverSocket.accept();
            
            ConnectionHandler connectionHandler = new ConnectionHandler(socket);
            connections.add(connectionHandler);
            pool.execute(connectionHandler);
            }
        } catch (IOException ex) {
            // TODO: Handle
            shutDown();
        }
    }
    
    public  void broadcast(String message) {
            for ( ConnectionHandler ch : connections) {
                if (ch != null) {
                    ch.sendMessage(message);
                }
            }
        }
    
    private void shutDown() {
        done = true;
         try {
             pool.shutdown();
        if ( !serverSocket.isClosed() ) {
            serverSocket.close();
            
            for ( ConnectionHandler ch : connections ) {
                ch.shutdown();
            }
        }
         } catch ( IOException e ) {
             //can't do anything about it
         } 
    }
    
    class ConnectionHandler implements Runnable {
        
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        String username;

        
        private ConnectionHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             
            username = in.readLine();
            System.out.println(username + " connected");
            broadcast(username + " joined the chat");
            
            String message;
            
            while ((message = in.readLine()) != null) {
                if (message.startsWith("/nick ")) {
                    
                } else if(message.startsWith("/quit")){
                    // TODO: quit the app
                    broadcast(username + " has left the chat!");
                    shutDown();
                    
                }else {
                    broadcast(username + " : " + message);
                }
            }
            
            } catch ( IOException e ) {
                // TODO: handle
                shutDown();
            }
            
        }
        
        public void sendMessage(String message) {
            out.println(message);
        }
        
        public void shutdown() {
            try {
                // closing the streams
                in.close();
                out.close();
                if ( !client.isClosed() ) {
                    client.close();
                }
            } catch (IOException e) {
                //TODO: nothing
            }
        }
        
    } 
    
}
