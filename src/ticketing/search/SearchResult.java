package ticketing.search;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchResult<T> {
    private List<T> results;
    public SearchResult(List<T> results) {
        this.results = results;
    }
    public List<T> filter(Predicate<T> condition) {
        return results.stream()
                .filter(condition)
                .collect(Collectors.toList());}
}

