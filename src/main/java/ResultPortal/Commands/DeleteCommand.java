package ResultPortal.Commands;

import ResultPortal.Data.DataStore;
import ResultPortal.Services.ResultService;

import java.util.Scanner;

public class DeleteCommand implements Command{
    private ResultService service;
    private Scanner sc;
    public DeleteCommand(ResultService service, Scanner sc) {
        this.service = service; this.sc = sc;
    }
    @Override
    public void execute() {
        System.out.print("Enter name: "); String nm = sc.nextLine();
        service.deleteRecord(nm);
        DataStore.save(service.viewAll());
        System.out.println("Deleted successfully!");
    }
}
