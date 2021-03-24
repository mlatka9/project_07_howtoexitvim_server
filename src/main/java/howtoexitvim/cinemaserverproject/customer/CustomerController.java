package howtoexitvim.cinemaserverproject.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public void bookSeats(@RequestBody Customer customer,
                          @RequestParam("seats") String seats,
                          @RequestParam("showId") Long showId){
        customerService.bookSeats(customer,seats,showId);
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

}
