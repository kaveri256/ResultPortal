package ResultPortal.Services.Strategy;

import ResultPortal.Models.SatResult;

public class CityFilter implements FilterStrategy{
    private String city;
    public CityFilter(String city){
        this.city = city;
    }
    @Override
    public boolean filter(SatResult result) {
        return result.getCity().equalsIgnoreCase(city);
    }
}
