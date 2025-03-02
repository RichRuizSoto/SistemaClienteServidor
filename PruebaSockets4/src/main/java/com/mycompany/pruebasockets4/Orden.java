
package com.mycompany.pruebasockets4;

import java.io.Serializable;

public class Orden implements Serializable{
    
    int type;

    public Orden(int type) {
        this.type = type;
    }
    

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Orden{" + "type=" + type + '}';
    }
    
    
    
    
    
}
