error id: file://<WORKSPACE>/src/main/java/br/thomas/App.java:java/io/PrintStream#println(+8).
file://<WORKSPACE>/src/main/java/br/thomas/App.java
empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 695
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
        Map<String, Runnable> commandMap = Map.of(
            "create", () -> {
                try{
                    createNewTask(reader, tasks);
                }catch(IOException ex){
                    System.out.pr@@intln("Exception of input/output detected.");
                }
            },
            "update", () -> updateTask(reader, tasks)
        );
        do{
            System.out.print("Enter task action: ");
            input = reader.readLine();
            commandMap.getOrDefault(input, () -> System.out.println("Invalid command.")).run();
        }while(!input.equals("exit"));
    }

    private static void createNewTask(BufferedReader reader, List<Task> tasks) throws IOException{
        Task task = new Task();
        System.out.print("Enter task description: ");
        String input = reader.readLine();
        task.setDescription(input);
        tasks.add(task);
        System.out.println("You created the task: " + task);
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
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/io/PrintStream#println(+8).