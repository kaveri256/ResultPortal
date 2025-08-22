package ResultPortal.Strategy;

import ResultPortal.Models.SatResult;

import java.util.List;

public class CompositeFilter implements FilterStrategy{
    private List<FilterStrategy> strategies;

    public CompositeFilter(List<FilterStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean filter(SatResult result) {
        // apply all strategies ANDed together
        for (FilterStrategy strategy : strategies) {
            if (!strategy.filter(result)) {
                return false;  // fails any one filter → reject
            }
        }
        return true;
    }
}
