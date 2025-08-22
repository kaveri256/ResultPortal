package ResultPortal.Commands;

import ResultPortal.Models.SatResult;
import ResultPortal.Services.ResultService;

public class ViewAllCommand implements Command{
    private ResultService service;
    public ViewAllCommand(ResultService service) { this.service = service; }

    @Override
    public void execute() {
        for (SatResult satResult : service.viewAll()) {
            System.out.println(satResult);
        }
    }
}
