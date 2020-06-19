package randomazer.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import randomazer.domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
