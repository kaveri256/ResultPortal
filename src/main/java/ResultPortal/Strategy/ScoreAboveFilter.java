package ResultPortal.Strategy;

import ResultPortal.Models.SatResult;

public class ScoreAboveFilter implements FilterStrategy{

    private int threshold;
    public ScoreAboveFilter(int threshold){
        this.threshold = threshold;
    }
    @Override
    public boolean filter(SatResult result) {
        return result.getSatScore() > threshold;
    }
}
