package ResultPortal.Services.Commands;
import ResultPortal.Data.DataStore;
import ResultPortal.Models.SatResult;
import ResultPortal.Services.ResultService;

import java.util.*;


public class InsertCommand implements Command{

    private ResultService service;
    private Scanner sc;

    public InsertCommand(ResultService service, Scanner sc) {
        this.service = service;
        this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Address: "); String address = sc.nextLine();
        System.out.print("City: "); String city = sc.nextLine();
        System.out.print("Country: "); String country = sc.nextLine();
        System.out.print("Pincode: "); String pincode = sc.nextLine();
        System.out.print("SAT Score: "); int score = sc.nextInt();
        sc.nextLine();

        SatResult res = new SatResult(name, address, city, country, pincode, score);
        service.insert(res);
        DataStore.save(service.viewAll());
        System.out.println("Inserted successfully!");
    }

}
