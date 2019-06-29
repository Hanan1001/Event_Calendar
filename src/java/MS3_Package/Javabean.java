/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MS3_Package;

/**
 *
 * @author Dosarihanan
 */
public class Javabean {
    
    public Javabean (){
    // Just a default constructor 
    }
    
    private int id;
    private String title ;
    private String description;
    private String date ;
    private String location ;
    
    //Setters 
    public void setId(int id){this.id = id;}
    public void setTitle(String title){this.title = title;}
    public void setDescription(String description){this.description = description;}
    public void setDate(String date){this.date = date;}
    public void setLocation(String location){this.location = location;}
    
    //Getters
    public int getId(){return this.id;}
    public String getTitle(){return this.title;}
    public String getDescription(){return this.description;}
    public String getDate(){return this.date;}
    public String getLocation(){return this.location;} 
    
}//end JavaBean
