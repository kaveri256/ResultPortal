package ResultPortal.Services.Commands;

import ResultPortal.Services.ResultService;

import java.util.Scanner;

public class RankCommand implements Command{
    private ResultService service;
    private Scanner sc;
    public RankCommand(ResultService service, Scanner sc) {
        this.service = service; this.sc = sc;
    }
    @Override
    public void execute() {
        System.out.print("Enter name: "); String nm = sc.nextLine();
        int rank = service.getRank(nm);
        System.out.println(rank == -1 ? "Not found" : "Rank: " + rank);
    }
}
