package pl.mumanski.offertlyapi.timeSlotManagement;

import lombok.Data;
import pl.mumanski.offertlyapi.userManagement.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "time_slots")
@Data
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    private Date startDate;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private TimeSlotState state;

}
