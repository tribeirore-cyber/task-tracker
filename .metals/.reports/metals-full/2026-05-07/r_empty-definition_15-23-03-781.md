error id: file://<WORKSPACE>/src/main/java/br/thomas/Task.java:java/time/LocalDateTime#
file://<WORKSPACE>/src/main/java/br/thomas/Task.java
empty definition using pc, found symbol in pc: java/time/LocalDateTime#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 776
uri: file://<WORKSPACE>/src/main/java/br/thomas/Task.java
text:
```scala
package br.thomas;

import java.time.LocalDateTime;

class Task {

    private int id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


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

    public void setUpdateAt(LocalDateTim@@e updatedAt){
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getUpdateAt(){
        return this.updatedAt;
    }
  
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: java/time/LocalDateTime#