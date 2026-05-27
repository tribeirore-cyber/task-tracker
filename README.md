# Task Tracker Project

Este é um simples aplicativo de linha de comando para gerenciar uma lista de tarefas.

## Funcionalidades Atuais

*   **Adicionar Tarefa**: Adiciona uma nova tarefa à lista.
*   **Atualizar Tarefa**: Atualiza o status de uma tarefa existente (atualmente, define como "in-progress").
*   **Remover Tarefa**: Remove uma tarefa da lista usando seu ID.

## Como Usar

### Pré-requisitos

*   JDK (Java Development Kit) instalado
*   Maven (para build)

### Compilar e Executar

1.  Clone o repositório:
    ```bash
    git clone [URL_DO_SEU_REPOSITORIO]
    cd task-tracker
    ```
2.  Compile o projeto usando Maven:
    ```bash
    mvn clean install
    ```
3.  Execute o aplicativo:
    ```bash
    java -jar target/task-tracker-1.0-SNAPSHOT.jar
    ```

### Comandos Disponíveis (dentro do aplicativo)

*   `add <descrição da tarefa>`: Adiciona uma nova tarefa. Ex: `add "Estudar Java"`
*   `update`: Solicita o ID da tarefa para atualizar (define como "in-progress").
*   `delete <id da tarefa>`: Remove uma tarefa pelo ID. Ex: `delete 1`
*   `exit`: Sai do aplicativo.

## Próximos Passos (Melhorias Futuras)

*   Implementar funcionalidade de listagem de tarefas.
*   Tratamento de erros mais robusto para entrada do usuário.
*   Melhorar a funcionalidade de atualização de tarefas (permitir alterar descrição, status para "concluído").
*   Utilizar Enums para o status da tarefa.
*   Separar a lógica de negócios da interface do usuário.
