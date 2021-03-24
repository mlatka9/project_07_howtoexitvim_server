package howtoexitvim.cinemaserverproject.seat;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    public void addSeat(@RequestBody Seat seat){
        seatService.addSeat(seat);
    }

    @GetMapping
    public List<Seat> getSeats(){
        return seatService.getSeats();
    }

}
