/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinedictionaryapplication;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author yaffa
 */
public class OnlineDictionaryApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        Map<String, String> dictionary = new HashMap<String, String>();
        String word;
        String meaning;
        ServerSocket s = new ServerSocket(6789);

        dictionary.put("dog", "type of animal");
        dictionary.put("trust","belief");dictionary.put("intelligent","clever");dictionary.put("rub","strok");
        dictionary.put("feed","give food to");dictionary.put("strange","foreign");dictionary.put("dangerous","unsafe");
        dictionary.put("land","ground");dictionary.put("adult","mature");dictionary.put("warning","caution");
        dictionary.put("deaf","unable to hear");dictionary.put("direction","way");dictionary.put("bee","insrct");
        System.out.println(dictionary.get("dog"));
        
        while(true) {
            Socket connectionSocket = s.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            word = inFromClient.readLine();
            meaning = dictionary.get(word)  + '\n';
            outToClient.writeBytes(meaning);
        }
    }
    
}
//creat a simple dictionary
//we need to cread a client who writes to the socket's buffer the word
//the server reads the word from the socket and stores it in a String variable
//this variable will be the key in the hashMap
//use the hashMap.get(Key) to get the word's mean and strre it in a String variable
//write the resulrs to the socket buffer
//the client reads the buffer contentd and prints the results