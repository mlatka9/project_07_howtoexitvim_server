package howtoexitvim.cinemaserverproject.show;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping
    public void addShow(@RequestBody Show show){
         showService.addShow(show);
    }

    @GetMapping
    public List<Show> getShows(){
        return showService.getShows();
    }
    @GetMapping("/{showId}/freeSeats")
    public Map<String,List<String>> getShow(@PathVariable("showId") Long showId){
        return showService.getShow(showId);
    }
}
