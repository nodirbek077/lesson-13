package task;

import java.util.Scanner;

public class TaskManager {

    public Task[] taskArray = new Task[10];
    public int currentIndex = 0;

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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
        String title = scanner.next();

        System.out.print("Enter content: ");
        String content = scanner.next();

        Task task = new Task();
        task.setTitle(title);
        task.setContent(content);
        return task;
    }

    private void addToArray(Task task) {
        //check task title and content
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
