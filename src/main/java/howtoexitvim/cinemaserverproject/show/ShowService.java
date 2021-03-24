package howtoexitvim.cinemaserverproject.show;

import howtoexitvim.cinemaserverproject.seat.Seat;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShowService {

    private final ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;

    }

    public void addShow(Show show) {
        Optional<Show> showByShowStart = showRepository
                .findShowByShowStart(show.getShowStart());

        if(showByShowStart.isPresent()){
            throw new IllegalStateException();
        }

        int j=0;
        int x=1;

        List<Seat> seats = new ArrayList<>();

        String[] tab = {"A","B","C","D","E","F","G","H","I","J"};

        for(int i=0;i<120;i++){
            if(i%12==0 && i!=0){
                j++;
            }
            if(i%12==0){
                x=0;
            }
            String miejsce = tab[j]+(x+1);

            Seat e = new Seat(miejsce, false, false);
            e.addShow(show);
            seats.add(e);
            x++;
        }

        String[] tab1 = {"K","L"};

        j=0;
        x=1;

        for(int i=0;i<12;i++){
            if(i%6==0 && i!=0){
                j++;
            }
            if(i%6==0){
                x=0;
            }
            String miejsce = tab1[j]+(x+1);

            Seat e = new Seat(miejsce, true, false);
            e.addShow(show);
            seats.add(e);
            x++;
        }

        show.setSeats(seats);

        showRepository.save(show);
    }

    public List<Show> getShows() {
        return showRepository.findAll();
    }

    public Map<String,List<String>> getShow(Long showId) {

        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new IllegalStateException("There is no show with id " + showId));

        List<String> collect = show.getSeats()
                .stream()
                .filter(n -> !n.getStatus())
                .map(Seat::getNumber)
                .collect(Collectors.toList());

        Map<String,List<String>> result = new HashMap<>();

        result.put("freeSeats",collect);

        return result;

    }
}
