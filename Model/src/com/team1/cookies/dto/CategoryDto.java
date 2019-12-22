package com.team1.cookies.dto;

/*
 * this created by H.Omar 
 * this class is the data transfer objects wich will travle between dao and front end 
 */
public class CategoryDto {
    public CategoryDto() {
        super();
    }

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private int id ; 
  

}
