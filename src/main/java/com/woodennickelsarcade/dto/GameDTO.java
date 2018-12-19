
package com.woodennickelsarcade.dto;

import com.woodennickelsarcade.datastore.Game;

public class GameDTO {
    private String name;
    private int id;
    private String description;
    private String agerating;
    private String imageurl;

    public GameDTO() {
    }

    public GameDTO(Game g) {
        id = g.getId();
        name = g.getName();
        description = g.getDescription();
        agerating = g.getAgerating();
        imageurl = g.getImageurl();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgerating() {
        return agerating;
    }

    public void setAgerating(String agerating) {
        this.agerating = agerating;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
