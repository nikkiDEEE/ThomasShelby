import java.util.Scanner;
import java.util.ArrayList;

public class ThomasShelby {
    public static void main(String[] args) {
        Task[] taskManager = new Task[100];
        int taskCount = 0;
        System.out.print("Good day, I'm Thomas Shelby\nTo what do I owe the pleasure?\n");
        Scanner in = new Scanner(System.in);
        while (true) {
            String cmd = in.nextLine();
            if (cmd.equals("bye")) {
                break;
            } else if (cmd.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 0; i < taskCount; i++) {
                    System.out.println((i + 1) + ". " + taskManager[i].getStatusIcon() + " " + taskManager[i].getDescription());
                }
            } else { // add cmd, mark or unmark
                String[] cmdSplit = cmd.split("\\s+");
                if (cmdSplit[0].equals("mark")) {
                    int whichTask = Integer.parseInt(cmdSplit[1]) - 1; // shift back index
                    taskManager[whichTask].setIsDone(true);
                    System.out.println("That was long due, well done.");
                    System.out.println(taskManager[whichTask].getStatusIcon() + " " + taskManager[whichTask].getDescription());
                } else if (cmdSplit[0].equals("unmark")) {
                    int whichTask = Integer.parseInt(cmdSplit[1]) - 1; // shift back index
                    taskManager[whichTask].setIsDone(false);
                    System.out.println("You've gotten lazy.");
                    System.out.println(taskManager[whichTask].getStatusIcon() + " " + taskManager[whichTask].getDescription());
                } else { // adding a new task
                    Task newTask = new Task(cmd);
                    newTask.setDescription(cmd);
                    taskManager[taskCount] = newTask;
                    taskCount++;
                    System.out.print("added: ");
                    System.out.println(cmd);
                }
            }
        }
        System.out.print("Cheers.");
    }
}