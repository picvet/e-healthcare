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
import java.net.Socket;

/**
 *
 * @author Percival
 */
public class Client implements Runnable {

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean done;
    private final String username;

    public Client(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    @Override
    public void run() {
        try {
            client = new Socket("127.0.0.1", 9999);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            InputHandler inputHandler = new InputHandler();
            Thread t = new Thread(inputHandler);
            
            t.start();
            
            String inMessage;
            
            while ((inMessage = in.readLine()) != null ) {
                System.out.println(inMessage);
            }
        } catch ( IOException e ) {
            shutdown();
        }
    }
    
    public void shutdown() {
        done = true;
         try { 
            
           in.close();
           out.close();
           if(!client.isClosed()) {
               client.close();
           }
        
         } catch ( IOException e ) {
             //can't do anything about it
         } 
    }
    
    class InputHandler implements Runnable {

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String message;
                
                while ( !done ) {
                    message = getUsername();
                    out.println(message);
                    
                    message = in.readLine();
                     
                    if (message.equals("/quit")){
                        out.println(message);
                        in.close();
                        shutdown();
                    } else {
                        out.println(message);
                    }
                    
                }
            } catch (IOException e) {
                shutdown();
            }
        }
        
    }
    
    public static void main(String[] arg) {
        Client client = new Client("Tim");
        client.run();
    }
    
}
