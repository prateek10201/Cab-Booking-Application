package com.cabbookingapp.backendapi.Model;

import javax.persistence.*;
import java.io.Serializable;

public class Ride {

    private String name;
    private int sourcexcord;
    private int sourceycord;
    private int destxcord;
    private int destycord;

    public Ride(String name, int sourcexcord, int sourceycord, int destxcord, int destycord) {
        this.name = name;
        this.sourcexcord = sourcexcord;
        this.sourceycord = sourceycord;
        this.destxcord = destxcord;
        this.destycord = destycord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSourcexcord() {
        return sourcexcord;
    }

    public void setSourcexcord(int sourcexcord) {
        this.sourcexcord = sourcexcord;
    }

    public int getSourceycord() {
        return sourceycord;
    }

    public void setSourceycord(int sourceycord) {
        this.sourceycord = sourceycord;
    }

    public int getDestxcord() {
        return destxcord;
    }

    public void setDestxcord(int destxcord) {
        this.destxcord = destxcord;
    }

    public int getDestycord() {
        return destycord;
    }

    public void setDestycord(int destycord) {
        this.destycord = destycord;
    }
}
