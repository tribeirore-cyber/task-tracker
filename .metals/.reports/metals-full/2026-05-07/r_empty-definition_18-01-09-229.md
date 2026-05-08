error id: file://<WORKSPACE>/src/main/java/br/thomas/App.java:java/io/InputStreamReader#
file://<WORKSPACE>/src/main/java/br/thomas/App.java
empty definition using pc, found symbol in pc: java/io/InputStreamReader#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 241
uri: file://<WORKSPACE>/src/main/java/br/thomas/App.java
text:
```scala
package br.thomas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    
    public static void main( String[] args ) {
        BufferedReader reader = new BufferedReader(new I@@nputStreamReader(System.in));
        String input = null;
        do{
            System.out.print("Enter task action: ");
            input = reader.readLine();
            if(input.equals("create")){
                createNewTask(reader);
            }
        }while(!input.equals("exit"));
    }

    private static void createNewTask(BufferedReader reader) throws IOException{
        Task task = new Task();
        System.out.print("Enter task description: ");
        String input = reader.readLine();
        task.setDescription(input);

        System.out.println("You created the task: " + task);
    }

}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/InputStreamReader#