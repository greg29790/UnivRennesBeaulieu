package com.gquere.univrennesbeaulieu;

import org.w3c.dom.Element;

import java.io.Serializable;

/**
 * Created by USER on 20/01/2018.
 */

public class Building implements Serializable {
    public final String id;
    public final String name;


    private Building(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Building(Element element)
    {
        id = element.getElementsByTagName("id").item(0).getTextContent();
        name = element.getElementsByTagName("name").item(0).getTextContent();
    }
}

