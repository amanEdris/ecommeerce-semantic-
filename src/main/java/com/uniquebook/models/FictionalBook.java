/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

import java.util.Date;

/**
 *
 * @author edris
 */
public class FictionalBook extends Book {
    private  String category;
    
    
    public FictionalBook() {
    }

    public enum FictionalCategory {

        COMICS("Comics"),
        FICTION("Fiction"),
        GRPAHICS_NOVEL("Graphical Novel"),
        LIERATURE("Literature"),
        POETRY("Poetry"),
        ROMANCE("Romance"),
        SCIENCE_FICTION("Science Fiction"),
        THRILLERS("Trillers"),
        WESTERNS("Westerns"),
        MISTERY("Mistry");

        public String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private FictionalCategory(String stringVal) {
            name = stringVal;
        }

        public String toString() {
            return name;
        }

        public static String getEnumByString(String code) {
           
            for (FictionalCategory e : FictionalCategory.values()) {
                if (code.equals(e.name)) {
                    return e.name();
                }
            }
            return null;
        }

    }
    
    
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "FictionalBook{" + "book=" + super.toString()+category+"--category";
    }
}
