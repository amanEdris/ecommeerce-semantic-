/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniquebook.models;

/**
 *
 * @author edris
 */
public class NonFictionalBook extends Book{
    public enum NonFictionalCategory {
         HISTORY,HOME__GARDEN,ACTIVITY__GAME_BOOKS,ANTIQUES__COLLECTIBLES, ARCHITECTURE,ART,
         BIBLE__CHRISTIANITY,BIOGRAPHY, BUSINESS_BOOKS, COMPUTERS, COOKBOOKS,FOOD__WINECRAFTS__HOBBIES, 
         CURRENT_AFFAIRS__POLITICS, DIET, HEALTH__FITNESS,EDUCATION, ENGINEERING, FORIEGN_LANGUAGES, HOME, LAW,
         MEDICINE__NURSING,PHILOSOPHY,PHOTOGRAPHY,PYSCOLOGY, RELIGION,SCIENCE__TECHNOLOGY,SELF_HELP__REALATIONSHIP,
         SOCIAL_SCIENCE,SPORTS,STUDY_AIDS__TEST,PREPARATION,TRAVEL,WEDDINGS
    };

    private  NonFictionalCategory category;

    public NonFictionalCategory getCategory() {
        return category;
    }

    public void setCategory(NonFictionalCategory category) {
        this.category = category;
    }

    
 

    public NonFictionalBook() {
    }

  

    @Override
    public String toString() {
        return "NonFictionalBook"+  super.toString();
    }
}
