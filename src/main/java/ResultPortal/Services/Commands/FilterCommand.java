package ResultPortal.Services.Commands;

import ResultPortal.Services.ResultService;
import ResultPortal.Services.Strategy.FailFilter;
import ResultPortal.Services.Strategy.PassFilter;

import java.util.Scanner;

public class FilterCommand implements Command{

    private ResultService service;
    private Scanner sc;
    public FilterCommand(ResultService service, Scanner sc) {
        this.service = service; this.sc = sc;
    }

    @Override
    public void execute() {
        System.out.print("Pass or Fail (P/F): ");
        String pf = sc.nextLine();
        boolean pass = pf.equalsIgnoreCase("P") || pf.equalsIgnoreCase("Pass");
        if(pass) {
            service.filter(new PassFilter()).forEach(System.out::println);
        }
        else{
            service.filter(new FailFilter()).forEach(System.out::println);
        }
    }
}
