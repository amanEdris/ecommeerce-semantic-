/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.controllers;

import com.uniquebook.models.FictionalBook;
import com.uniquebook.models.KidsBook;
import com.uniquebook.models.NonFictionalBook;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("fictionalCategory", FictionalBook.FictionalCategory.values());
        event.getServletContext().setAttribute("nonfictionCategory",NonFictionalBook.NonFictionalCategory.values() );
        event.getServletContext().setAttribute("kidsCategory",KidsBook.kidsBookCategory.values() );
      
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP
    }

}