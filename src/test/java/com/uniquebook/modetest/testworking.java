/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.modetest;

import com.uniquebook.dao.FictionalBooksDao;
import com.uniquebook.dao.KidsBookDao;
import com.uniquebook.dao.NonFictionalBooksDao;

/**
 *
 * @author edris
 */
public class testworking {
   private static String path= "/usr/local/apache-tomcat-9.0.0.M21/webapps/UniqueBookApp//image/10635951_749551151802231_6403114914420571375_n.jpg";
    
       public static void main(String[] args) throws Exception {
          String  tempName;
          tempName = path.substring(path.lastIndexOf("/image") );
          tempName = "."+tempName; 
          System.out.println("The image that is uploaded to the system is: "+tempName.toString());
       }

   
}
