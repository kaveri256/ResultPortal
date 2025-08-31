package ResultPortal;

import ResultPortal.Data.DataStore;
import ResultPortal.Repository.ResultRepository;
import ResultPortal.Services.Commands.*;
import ResultPortal.Services.ResultService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Portal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResultRepository repository = ResultRepository.getInstance();
        ResultService service = new ResultService(repository);

        // Load existing data
        DataStore.load().forEach(repository::add);

        // Map choices to commands
        Map<Integer, Command> menu = new HashMap<>();
        menu.put(1, new InsertCommand(service, sc));
        menu.put(2, new ViewAllCommand(service));
        menu.put(3, new RankCommand(service, sc));
        menu.put(4, new UpdateCommand(service, sc));
        menu.put(5, new DeleteCommand(service, sc));
        menu.put(6, new AverageCommand(service));
        menu.put(7, new FilterCommand(service, sc));

        while (true) {
            System.out.println("\n--- SAT Results Management ---");
            System.out.println("1. Insert data");
            System.out.println("2. View all data");
            System.out.println("3. Get rank");
            System.out.println("4. Update score");
            System.out.println("5. Delete one record");
            System.out.println("6. Calculate Average SAT Score");
            System.out.println("7. Filter records by Pass/Fail");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            // consume newline

            try {
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 8) {
                    System.out.println("Exiting...");
                    break;
                }

                Command command = menu.get(choice);
                if (command != null) {
                    try {
                        command.execute();
                    } catch (Exception e) {
                        System.out.println("An error occurred while executing command: " + e.getMessage());
                    }
                } else {
                    System.out.println("Invalid choice! Please select a valid option.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                break;
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                break;
            }
        }
    }
}
