package randomazer.repos;

import org.springframework.data.repository.CrudRepository;
import randomazer.domain.Numeric;
import randomazer.domain.User;

import java.util.List;

public interface NumericRepo extends CrudRepository<Numeric, Long> {
    List<Numeric> findByAuthor(User user);
}
