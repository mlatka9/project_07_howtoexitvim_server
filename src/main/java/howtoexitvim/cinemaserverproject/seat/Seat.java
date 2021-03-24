package howtoexitvim.cinemaserverproject.seat;

import howtoexitvim.cinemaserverproject.show.Show;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Seat {

    @Id
    @SequenceGenerator(
            name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seat_sequence")
    @Column(name = "id_seat", nullable = false)
    private Long idSeat;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "type_vip", nullable = false)
    private Boolean typeVip;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JoinColumn(
            name = "show_id",
         //   nullable = false,
            referencedColumnName = "show_id",
            foreignKey = @ForeignKey(
                    name = "show_seat_fk"
            )
    )
    private Show show;

    public void addShow(Show show) {
        this.show=show;
    }

    public Seat(String number, Boolean typeVip, Boolean status) {
        this.number = number;
        this.typeVip = typeVip;
        this.status = status;
    }
}
