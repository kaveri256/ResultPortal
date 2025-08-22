package ResultPortal.Services.Commands;

import ResultPortal.Data.DataStore;
import ResultPortal.Services.ResultService;

import java.util.Scanner;

public class UpdateCommand implements Command{
    private ResultService service;
    private Scanner sc;
    public UpdateCommand(ResultService service, Scanner sc) {
        this.service = service; this.sc = sc;
    }
    @Override
    public void execute() {
        System.out.print("Enter name: "); String nm = sc.nextLine();
        System.out.print("New score: "); int score = sc.nextInt();
        sc.nextLine();
        service.updateScore(nm, score);
        DataStore.save(service.viewAll());
        System.out.println("Updated successfully!");
    }
}
