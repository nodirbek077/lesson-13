package task;

import java.io.BufferedReader;
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
                    String title = changeStatusByName();
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
                    break;
                case 4:
                    int id = changeStatusById();
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
        for (Task task : taskArray) {
            if (task != null) {
                System.out.println(task.getId() + " " +
                        task.getTitle() + " " +
                        task.getContent() + " " +
                        task.getStatus());
            }
        }
    }

    public String changeStatusByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter title: ");
        return scanner.nextLine();
    }

    public int changeStatusById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        return scanner.nextInt();
    }

    public void printActiveTaskList(){
        for (Task task : taskArray) {
            if (task != null) {
                if (task.getStatus().equals("ACTIVE")) {
                    System.out.println(task.getId() + " " + task.getTitle() + " " + task.getContent());
                }
            }
        }
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
