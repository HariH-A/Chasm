
import java.util.ArrayList;

public class AllFilters implements Filters {
    ArrayList<Filters> filters;
    
    public AllFilters() {
        filters = new ArrayList<Filters>();
    }

    public void addFilter(Filters f) {
        filters.add(f);
    }

    @Override
    public boolean satisfies(String id) {
        for(Filters f : filters) {
            if (! f.satisfies(id)) {
                return false;
            }
        }
        
        return true;
    }

}