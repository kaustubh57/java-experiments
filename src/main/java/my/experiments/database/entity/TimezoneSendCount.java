package my.experiments.database.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SS_TIMEZONE_SEND_COUNT")
@Data
@EqualsAndHashCode
public class TimezoneSendCount implements Serializable {

    @Id
    @SequenceGenerator(name = "timezoneSendCountSequence", sequenceName = "SS_TIMEZONE_SEND_COUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timezoneSendCountSequence")
    @Column(name = "SS_TIMEZONE_SEND_COUNT_ID")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "MAILING_ID", referencedColumnName = "MAILING_ID")
    private SendCount sendCount;

    @Column(name = "CREATED_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "NUM_RECIPIENTS")
    private Long numRecipients;

    @Column(name = "TIMEZONEID")
    private String timezoneId;
}
