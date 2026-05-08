error id: file://<WORKSPACE>/src/main/java/br/thomas/App.java:_empty_/Array#length.
file://<WORKSPACE>/src/main/java/br/thomas/App.java
empty definition using pc, found symbol in pc: _empty_/Array#length.
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 716
uri: file://<WORKSPACE>/src/main/java/br/thomas/App.java
text:
```scala
package br.thomas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        List<Task> tasks = new ArrayList<>();
        do{
            System.out.print("Enter task action: ");
            input = reader.readLine();
            String[] parts = input.stripLeading().split(" ", 2);
            String command = parts[0];
            String inputText = parts.l@@ength > 1 ? parts[1] : "";
            switch(command){
                case "add":
                    addNewTask(input, tasks);
                    break;
                case "update":
                    updateTask(reader, tasks);
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }while(!input.equals("exit"));
    }

    private static void addNewTask(String taskDescription, List<Task> tasks) {
        Task task = new Task();
        String description = taskDescription.substring(2).replace('"', ' ').stripLeading();
        task.setDescription(description);
        tasks.add(task);
        System.out.printf("Task added successfully (ID: %d)\n", task.getId());
    }

    private static void updateTask(BufferedReader reader, List<Task> tasks) throws IOException{
        Task task = findTaskById(reader, tasks);
        task.setUpdateAt(LocalDateTime.now());
        task.setStatus("in-progress");
        System.out.println("The task is updated");
    }

    private static Task findTaskById(BufferedReader reader, List<Task> tasks) throws IOException{
        System.out.print("Enter the task id to be updated: ");
        String input = reader.readLine();
        int id = Integer.parseInt(input);
        return tasks.stream().filter(
            t -> t.getId() == id
        ).findFirst().get();
    }

    return () -> {
        try {
            command.execute();
        } catch (IOException ex) {
            System.out.println("Exception of input/output detected.");
        }
    };
}   
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/Array#length.