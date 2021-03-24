package howtoexitvim.cinemaserverproject.show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {

    Optional<Show> findShowByShowStart(LocalDateTime showStart);



}
