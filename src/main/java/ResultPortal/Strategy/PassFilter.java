package ResultPortal.Strategy;

import ResultPortal.Models.SatResult;

public class PassFilter implements FilterStrategy{
    @Override
    public boolean filter(SatResult result) {
        return result.isPassed();
    }
}
