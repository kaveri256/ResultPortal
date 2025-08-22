package ResultPortal.Services;

import ResultPortal.Models.SatResult;
import ResultPortal.Repository.ResultRepository;
import ResultPortal.Strategy.FilterStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultService {

    private final ResultRepository repository;

    public ResultService(ResultRepository repository) {
        this.repository = repository;
    }

    //inserting record
    public void insert(SatResult result) { repository.add(result); }

    //getting all the records
    public List<SatResult> viewAll() { return repository.findAll(); }

    //Getting a Student Rank
    public int getRank(String name) {
        List<SatResult> sorted = new ArrayList<>();
        for (SatResult satResult : repository.findAll()) {
            sorted.add(satResult);
        }
        sorted.sort(Comparator.comparingInt(SatResult::getSatScore).reversed());

        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).getName().equalsIgnoreCase(name)) return i + 1;
        }
        return -1; // not found
    }

    //Updating the Score
    public void updateScore(String name, int newScore) {
        SatResult res = repository.findByName(name);
        if (res != null) {
            res.setSatScore(newScore);
            res.setPassed(newScore>30);
        }

    }

    //Deleting Record
    public void deleteRecord(String name) {
        repository.deleteByName(name);
    }

    //Finding Average Score
    public double calculateAverage() {
        long sum = 0;
        long count = 0;
        for (SatResult satResult : repository.findAll()) {
            int satScore = satResult.getSatScore();
            sum += satScore;
            count++;
        }
        return count > 0 ? (double) sum / count : 0.0;
    }

    //Pass Fail Filter
    public List<SatResult> filter(FilterStrategy strategy) {
         return repository.findAll().stream()
                .filter(strategy::filter)
                .collect(Collectors.toList());
    }

}
