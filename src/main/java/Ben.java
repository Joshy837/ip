import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ben {
    public static void main(String[] args) {

        // instantiate new task-list
        List<Task> taskList = new ArrayList<>();

        // Introduction
        System.out.println("   ______________________________________________");
        System.out.println("   Hello! I'm Ben");
        System.out.println("   What can I do for you?");
        System.out.println("   ______________________________________________");

        // Read the text entered by user line by line
        Scanner sc = new Scanner(System.in);

        // runs the program until user inputs "bye"
        while (sc.hasNext()) {

            // scan next line
            String input = sc.nextLine();

            System.out.println("   ______________________________________________");

            // delimited using " "
            String[] tokens = input.split(" ", 2);
            String command = tokens[0];

            switch (command) {

                // exits the program
                case "bye":
                    System.out.println("   Bye. Hope to see you again soon!");
                    System.out.println("   ______________________________________________");
                    System.exit(0);

                // list out items in task-list
                case "list":
                    System.out.println("   Here are the tasks in your list:");
                    for (int i = 0; i < taskList.size(); i++) {
                        Task currTask = taskList.get(i);
                        System.out.println("   " + (i + 1) + ". " + currTask);
                    }
                    break;

                // mark a task
                case "mark": {
                    // empty field
                    if (tokens.length < 2) {
                        System.out.println("   Key in a value!");
                        break;
                    }

                    int index = Integer.parseInt(tokens[1]) - 1;

                    if (taskList.isEmpty()) {
                        System.out.println("   There are no pending tasks now... Add some tasks here!");
                        break;
                    }

                    if (index < 0 || index > taskList.size() - 1) {
                        System.out.println("   Please input a valid number between 1 and " + taskList.size());
                        break;
                    }

                    Task currTask = taskList.get(index);
                    currTask.markTask();

                    System.out.println("   Nice! I've marked this task as done:");
                    System.out.println("      " + currTask);
                    break;
                }

                // unmark a task
                case "unmark": {
                    // empty field
                    if (tokens.length < 2) {
                        System.out.println("   Key in a value!");
                        break;
                    }

                    int index = Integer.parseInt(tokens[1]) - 1;

                    if (taskList.isEmpty()) {
                        System.out.println("   There are no pending tasks now... Add some tasks here!");
                        break;
                    }

                    if (index < 0 || index > taskList.size() - 1) {
                        System.out.println("   Please input a valid number between 1 and " + taskList.size());
                        break;
                    }

                    Task currTask = taskList.get(index);
                    currTask.unmarkTask();

                    System.out.println("   OK, I've marked this task as not done yet:");
                    System.out.println("      " + currTask);
                    break;
                }

                // create new to-do task
                case "todo": {
                    // empty to-do
                    if (tokens.length < 2) {
                        System.out.println("   OOPS!!! The description of a todo cannot be empty.");
                        break;
                    }

                    String description = tokens[1];
                    Task newTodoTask = new Todo(description);
                    taskList.add(newTodoTask);

                    System.out.println("   Got it. I've added this task:");
                    System.out.println("      " + newTodoTask);
                    System.out.println("   Now you have " + taskList.size() + " tasks in the list.");
                    break;
                }

                // create new deadline task
                case "deadline": {
                    // empty deadline
                    if (tokens.length < 2) {
                        System.out.println("   OOPS!!! The description of a deadline cannot be empty.");
                        break;
                    }

                    // delimiting string
                    String information = tokens[1];
                    String[] descTokens = information.split(" /by ");
                    String description = descTokens[0];
                    String by = descTokens[1];

                    // create new task
                    Task newDeadlineTask = new Deadline(description, by);
                    taskList.add(newDeadlineTask);

                    System.out.println("   Got it. I've added this task:");
                    System.out.println("      " + newDeadlineTask);
                    System.out.println("   Now you have " + taskList.size() + " tasks in the list.");
                    break;
                }

                // create new event task
                case "event": {
                    // empty event
                    if (tokens.length < 2) {
                        System.out.println("   OOPS!!! The description of an event cannot be empty.");
                        break;
                    }

                    // delimiting string
                    String information = tokens[1];
                    String[] descTokens = information.split(" /from ");
                    String description = descTokens[0];
                    String dates = descTokens[1];
                    String[] dateTokens = dates.split(" /to ");
                    String startDate = dateTokens[0];
                    String endDate = dateTokens[1];

                    // create new task
                    Task newEventTask = new Event(description, startDate, endDate);
                    taskList.add(newEventTask);

                    System.out.println("   Got it. I've added this task:");
                    System.out.println("      " + newEventTask);
                    System.out.println("   Now you have " + taskList.size() + " tasks in the list.");
                    break;
                }

                // delete a current task
                case "delete":
                    // empty field
                    if (tokens.length < 2) {
                        System.out.println("   Key in a value");
                        break;
                    }

                    int index = Integer.parseInt(tokens[1]) - 1;

                    if (taskList.isEmpty()) {
                        System.out.println("   No tasks to delete :)");
                        break;
                    }

                    if (index < 0 || index > taskList.size() - 1) {
                        System.out.println("   Please input a valid number between 1 and " + taskList.size());
                        break;
                    }

                    // delete task from list
                    Task deletedTask = taskList.remove(index);

                    System.out.println("   Noted. I've removed this task:");
                    System.out.println("      " + deletedTask);
                    System.out.println("   Now you have " + taskList.size() + " tasks in the list.");
                    break;

                // add general task to task-list
                default:
                    System.out.println("   OOPS!!! I'm sorry, but I don't know what that means :-(");
                    break;
            }

            System.out.println("   ______________________________________________");
        }
    }
}
