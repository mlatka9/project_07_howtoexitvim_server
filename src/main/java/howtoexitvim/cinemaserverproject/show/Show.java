package howtoexitvim.cinemaserverproject.show;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import howtoexitvim.cinemaserverproject.seat.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "seats"})
public class Show {

    @Id
    @SequenceGenerator(
            name = "show_sequence",
            sequenceName = "show_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "show_sequence")
    @Column(name = "show_id", nullable = false)
    private Long showId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Column(name = "show_start", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime showStart;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(
            targetEntity=Seat.class,
            cascade=CascadeType.ALL
//            cascade = CascadeType.PERSIST
//            mappedBy = "show",
//            cascade = CascadeType.PERSIST,
//            fetch = FetchType.LAZY
    )
    private List<Seat> seats = new ArrayList<>();

    public Show(String title, Integer duration, LocalDateTime showStart, String description) {
        this.title = title;
        this.duration = duration;
        this.showStart = showStart;
        this.description = description;
    }
}
