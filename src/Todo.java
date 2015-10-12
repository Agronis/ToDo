import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Agronis on 10/12/15.
 */
public class Todo {
    public static void main(String[] args) {
        ArrayList<Item> todos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int tNum = 1;
            for (Item todo : todos) {
                String checkBox = "[ ]";
                if (todo.isDone) {
                    checkBox = "[x]";
                }
                System.out.println(tNum + ". " + checkBox + " " + todo.text);
                tNum++;
            }

            System.out.println("Option");
            System.out.println("[1] Create ToDo.");
            System.out.println("[2] Mark ToDo as done or not done.");

            String option = scanner.nextLine();
            int optionNum = Integer.valueOf(option);

            if (optionNum == 1) {
                System.out.println("What would you like to add?");
                String todo = scanner.nextLine();
                Item item = new Item(todo);
                todos.add(item);
            } else if (optionNum == 2) {
                System.out.println("Which ToDo would you like to toggle?");
                String todo = scanner.nextLine();
                try {
                    int numDone = Integer.valueOf(todo);
                    Item item = todos.get(numDone - 1);
                    item.isDone = !item.isDone;
                } catch (Exception e) {
                    System.out.println("An error has occured.");
                }
            }
            else {
                System.out.println("Invalid Number.");
            }
        }
    }
}
