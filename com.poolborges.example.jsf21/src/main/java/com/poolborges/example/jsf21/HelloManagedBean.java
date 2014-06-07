package com.poolborges.example.jsf21;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Borges
 */
@ManagedBean(name = "helloMBean") 
@RequestScoped
public class HelloManagedBean  implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String message;
    
    public String getName() {
        return name;  
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    public String submit(){
    
        StringBuilder strBuff = new StringBuilder();
        strBuff.append("Senhor/a ").append(this.getName());
        this.setMessage(strBuff.toString());
        
        return  "success";
    }
    
    public void reset() {
        this.setName("");
    }
}
