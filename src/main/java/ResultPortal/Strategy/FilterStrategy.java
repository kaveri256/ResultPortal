package ResultPortal.Strategy;

import ResultPortal.Models.SatResult;

public interface FilterStrategy {
    boolean filter(SatResult result);
}
