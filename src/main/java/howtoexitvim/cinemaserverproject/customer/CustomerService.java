package howtoexitvim.cinemaserverproject.customer;

import howtoexitvim.cinemaserverproject.seat.Seat;
import howtoexitvim.cinemaserverproject.show.Show;
import howtoexitvim.cinemaserverproject.show.ShowRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ShowRepository showRepository;

    public CustomerService(CustomerRepository customerRepository, ShowRepository showRepository) {
        this.customerRepository = customerRepository;
        this.showRepository = showRepository;
    }

    public void bookSeats(Customer customer, String seats, Long showId) {

        Show show = showRepository.findById(showId).orElseThrow(
                () -> new IllegalStateException("There is not show with id" + showId)
        );

        List<Seat> seats1 = show.getSeats();
        String[] split = seats.split(",");

        List<Seat> list = new ArrayList<>();

        for (String seatId : split) {
            for (Seat seat : seats1) {
                if (String.valueOf(seat.getNumber()).equals(seatId)) {
                    seat.setStatus(true);
                    list.add(seat);
                }
            }
        }
        customer.setSeats(list);
        customerRepository.save(customer);
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
}
