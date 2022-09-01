import java.util.List;

public interface Repository<T> {

    void saveAll(List<T> entities);
}
