package br.thomas;

import java.time.LocalDateTime;

class Task {

    private static int idCounter = 0;

    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(){
        this.id = ++idCounter;
        this.createdAt = LocalDateTime.now();
        this.status = "todo";
    }


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }

    public void setUpdateAt(LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdateAt(){
        return this.updatedAt;
    }

    @Override
    public String toString(){
        return this.description + " - " + this.status;
    }
  
}