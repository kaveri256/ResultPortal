package ResultPortal.Services.Commands;

import ResultPortal.Services.ResultService;

public class AverageCommand implements Command{
    private ResultService service;
    public AverageCommand(ResultService service) { this.service = service; }

    @Override
    public void execute() {
        System.out.println("Average SAT Score = " + service.calculateAverage());
    }
}
