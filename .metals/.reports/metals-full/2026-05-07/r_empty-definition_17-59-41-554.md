error id: file://<WORKSPACE>/src/main/java/br/thomas/App.java:java/io/BufferedReader#
file://<WORKSPACE>/src/main/java/br/thomas/App.java
empty definition using pc, found symbol in pc: java/io/BufferedReader#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 244
uri: file://<WORKSPACE>/src/main/java/br/thomas/App.java
text:
```scala
package br.thomas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    
    public static void main( String[] args ) throws IOException{
        BufferedReader reader = new Buffe@@redReader(new InputStreamReader(System.in));
        String input = null;
        do{
            
        }while(!input.equals("exit"));
    }

    private void createNewTask(){
        Task task = new Task();
        System.out.print("Enter task description: ");
        input = reader.readLine();
        task.setDescription(input);

        System.out.println("You created the task: " + task);
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/BufferedReader#