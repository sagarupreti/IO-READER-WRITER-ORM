/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibt;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;


/**
 *
 * @author ideapad-520S
 */
public class Program {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            String path="e:/java practice/IO/practice8/";
            try(BufferedReader reader=new BufferedReader(
            new FileReader("E:/java practice/IO/practice8/data.txt"))){
                String line="";
                while((line=reader.readLine())!=null){
                    System.out.println("downloading \n"+line);
                    String[] tokens= line.split("/");
                    String fileName=tokens[tokens.length-1];
                    
                 URLConnection conn=
                         new URL(line).openConnection();
                 InputStream is=conn.getInputStream();
                 OutputStream os=new 
                            FileOutputStream(path+fileName);
                 
                int i=0;
                byte[] data=new byte[1024*5];
                while((i=is.read(data))!=-1){
                    os.write(data, 0, i);
                }
                 is.close();
                 os.close();
                }
            }
            
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
            
        }
         
    }
} 
