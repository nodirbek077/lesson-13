package task;

import java.util.Scanner;

public class TaskManager {

    public Task[] taskArray = new Task[10];
    public int currentIndex = 0;
    public int generalId = 1;

    public void start() {
        boolean b = true;
        while (b) {
            menu();
            int n = getMenuNumber();
            switch (n) {
                case 1:
                    Task task = addTask();
                    addToArray(task);
                    break;
                case 2:
                    printAllTask();
                    break;
                case 3:
                    String title = getTaskTitle();
                    changeStatusByTitle(title);
                    break;
                case 4:
                    int id = getTaskId();
                    changeStatusById(id);
                    break;
                case 5:
                    printActiveTaskList();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    System.out.println("Please choose correct number!");
            }
        }
    }

    public Task addTask() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);
        return task;
    }

    public void addToArray(Task task) {
        //check task title and content

        task.setStatus("ACTIVE");
        task.setId(generalId++);

        if (taskArray.length == currentIndex) {
            Task[] newArr = new Task[currentIndex * 2];
            for (int i = 0; i < currentIndex; i++) {
                newArr[i] = taskArray[i];
            }
            taskArray = newArr;
        }
        taskArray[currentIndex] = task;
        currentIndex++;
    }

    public void printAllTask() {
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("|                              Task List                                |%n");
        System.out.printf("-------------------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-36s | %-6s |%n", "Id", "Title", "Content", "Status");
        System.out.printf("-------------------------------------------------------------------------%n");
        for (Task task : taskArray) {
            if (task != null) {
                System.out.printf("| %-3s | %-15s | %-36s | %-6s |%n",
                        task.getId(),
                        task.getTitle(),
                        task.getContent(),
                        task.getStatus());
            }
        }
        System.out.printf("-------------------------------------------------------------------------%n");
    }

    public String getTaskTitle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        return scanner.nextLine();
    }

    public void changeStatusByTitle(String title) {
        for (Task t : taskArray) {
            if (t != null && t.getTitle().equals(title)) {
                if (t.getStatus().equals("ACTIVE")) {
                    t.setStatus("DONE");
                } else {
                    t.setStatus("ACTIVE");
                }
                break;
            }
        }
    }

    public int getTaskId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        return scanner.nextInt();
    }

    public void changeStatusById(int id) {
        for (Task t : taskArray) {
            if (t != null && t.getId() == id) {
                if (t.getStatus().equals("ACTIVE")) {
                    t.setStatus("DONE");
                } else {
                    t.setStatus("ACTIVE");
                }
                break;
            }
        }
    }

    public void printActiveTaskList() {
        System.out.printf("----------------------------------------------------------------%n");
        System.out.printf("|                       Active Task List                       |%n");
        System.out.printf("----------------------------------------------------------------%n");
        System.out.printf("| %-3s | %-15s | %-36s |%n", "Id", "Title", "Content");
        System.out.printf("----------------------------------------------------------------%n");
        for (Task task : taskArray) {
            if (task != null && task.getStatus().equals("ACTIVE")) {
                System.out.printf("| %-3s | %-15s | %-36s |%n",
                        task.getId(),
                        task.getTitle(),
                        task.getContent());
            }
        }
        System.out.printf("----------------------------------------------------------------%n");
    }

    public void menu() {
        System.out.println("** Menu **");
        System.out.println("1-Add Task");
        System.out.println("2-Task List");
        System.out.println("3-Change Status by name");
        System.out.println("4-Change Status by id");
        System.out.println("5-Active task list");
        System.out.println("0-Exit");
    }

    public int getMenuNumber() {
        System.out.print("Choose menu: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
