package ResultPortal.Services.Strategy;

import ResultPortal.Models.SatResult;

public class FailFilter implements FilterStrategy{
    @Override
    public boolean filter(SatResult result) {
        return !result.isPassed();
    }
}
