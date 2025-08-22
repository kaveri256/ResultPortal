package ResultPortal.Repository;
import java.util.ArrayList;
import ResultPortal.Models.SatResult;
import java.util.List;

public class ResultRepository {

    private static ResultRepository instance;
    private final List<SatResult> records = new ArrayList<>();

    private ResultRepository() {}  // private constructor

    public static synchronized ResultRepository getInstance() {
        if (instance == null) {
            instance = new ResultRepository();
        }
        return instance;
    }


    public void add(SatResult result) { records.add(result); }

    public List<SatResult> findAll() { return records; }

    public SatResult findByName(String name) {
        return records.stream().filter(r -> r.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
    public void deleteByName(String name) {
        records.removeIf(r -> r.getName().equalsIgnoreCase(name));
    }
}
