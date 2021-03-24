package howtoexitvim.cinemaserverproject.seat;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {


    private final  SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void addSeat(Seat seat) {
        seatRepository.save(seat);
    }

    public List<Seat> getSeats() {
        return seatRepository.findAll();
    }
}
