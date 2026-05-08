error id: file://<WORKSPACE>/src/main/java/br/thomas/App.java
file://<WORKSPACE>/src/main/java/br/thomas/App.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[58,1]

error in qdox parser
file content:
```java
offset: 2069
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
                    System.out.println("Exception of input/output detected.");
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
@@
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
	java.base/java.lang.Thread.run(Thread.java:840)
```
#### Short summary: 

QDox parse error in file://<WORKSPACE>/src/main/java/br/thomas/App.java