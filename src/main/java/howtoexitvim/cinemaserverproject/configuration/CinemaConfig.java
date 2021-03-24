package howtoexitvim.cinemaserverproject.configuration;

import howtoexitvim.cinemaserverproject.seat.SeatRepository;
import howtoexitvim.cinemaserverproject.show.ShowRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CinemaConfig {

    @Bean
    CommandLineRunner commandLineRunner(ShowRepository showRepository, SeatRepository seatRepository) {

        return args -> {
        };
    }

}


