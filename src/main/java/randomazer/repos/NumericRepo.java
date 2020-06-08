package randomazer.repos;

import org.springframework.data.repository.CrudRepository;
import randomazer.domain.Numeric;

public interface NumericRepo extends CrudRepository<Numeric, Integer> {
}
