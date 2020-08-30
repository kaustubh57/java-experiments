package my.experiments.database.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.QueryHints;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "my.experiments.database.entity.SendCount")
@Table(name = "SS_SEND_COUNT")
@NamedQueries({
        @NamedQuery(
                name = "SendCount.findLatestTimeZoneSendCountForMobilePush",
                query = "SELECT sc FROM my.experiments.database.entity.SendCount sc " +
                        "LEFT JOIN FETCH sc.timezoneSendCounts tsc " +
                        "WHERE  sc.listId = :listId " +
                        "AND sc.channelId = :channelId " +
                        "AND sc.status = :status " +
                        "AND sc.channelQualifiers = :channelQualifiers " +
                        "ORDER  BY sc.creationDate DESC ",
                hints = @QueryHint(name = QueryHints.COMMENT, value = "BOGUS COMMENT")
        )
})

@NamedNativeQueries(value = {
        @NamedNativeQuery(
                name = "SendCount.findLatestTimeZoneSendCountForMobilePushUsingNamedNativeQuery",
                query = "SELECT /*one more hint here*/  sc.* ," +
                        "stsc.* " +
                        "FROM SS_SEND_COUNT sc " +
                        "LEFT OUTER JOIN ss_timezone_send_count stsc " +
                        "    ON sc.mailing_id = stsc.mailing_id " +
                        "WHERE  sc.list_id2 = :listId " +
                        "AND sc.channel_id = :channelId " +
                        "AND sc.status = :status " +
                        "AND sc.channel_qualifiers = :channelQualifiers " +
                        "ORDER  BY sc.created_ts DESC ",
                resultClass = SendCount.class,
                hints = @QueryHint(name = QueryHints.FLUSH_MODE, value = "Always")
        )
})
@EqualsAndHashCode
@Data
public class SendCount implements Serializable {

    @Id
    @SequenceGenerator(name = "sendCountSequence", sequenceName = "SS_SEND_COUNT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sendCountSequence")
    @Column(name = "SS_SEND_COUNT_ID")
    private Long id;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "LIST_ID2")
    private Long listId;

    @Column(name = "MAILING_ID")
    private Long mailingId;

    @Column(name = "JOB_ID")
    private Long jobId;

    @Column(name = "CREATED_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Column(name = "CALCULATED_TS")
    @Temporal(TemporalType.TIMESTAMP)
    private Date calculatedDate;

    @Column(name = "SUPPRESSION_LIST_IDS")
    private String suppressionListIds;

    @Column(name = "NUM_SENT")
    private Long numSent;

    @Column(name = "NUM_SUPPRESSED")
    private Long numSuppressed;

    @Column(name = "NUM_SEEDS")
    private Long numSeeds;

    @Column(name = "NUM_TOTAL_RECIPIENTS")
    private Long numTotalRecipients;

    @Column(name = "CHANNEL_QUALIFIERS")
    private String channelQualifiers;

    @Column(name = "CHANNEL_ID")
    private Long channelId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sendCount", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    List<TimezoneSendCount> timezoneSendCounts = new ArrayList<>();

//    public Long getId() {
//        return id;
//    }
//
//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }
//
//    public Date getCalculatedDate() {
//        return calculatedDate;
//    }
//
//    public Long getListId() {
//        return listId;
//    }
//
//    public void setListId(Long listId) {
//        this.listId = listId;
//    }
//
//    public Long getMailingId() {
//        return mailingId;
//    }
//
//    public void setMailingId(Long mailingId) {
//        this.mailingId = mailingId;
//    }
//
//    public Long getJobId() {
//        return jobId;
//    }
//
//    public void setJobId(Long jobId) {
//        this.jobId = jobId;
//    }
//
//    public String getSuppressionListIds() {
//        return suppressionListIds;
//    }
//
//    public void setSuppressionListIds(String suppressionListIds) {
//        this.suppressionListIds = suppressionListIds;
//    }
//
//    public Long getNumSeeds() {
//        return numSeeds;
//    }
//
//    public Long getNumSuppressed() {
//        return numSuppressed;
//    }
//
//    public Long getNumSent() {
//        return numSent;
//    }
//
//    public Long getNumTotalRecipients() {
//        return numTotalRecipients;
//    }
//
//    public String getChannelQualifiers() { return channelQualifiers; }
//
//    public void setChannelQualifiers(String channelQualifiers) { this.channelQualifiers = channelQualifiers; }
//
//    public Long getChannelId() { return channelId; }
//
//    public void setChannelId(Long channelId) { this.channelId = channelId; }
//
//    public List<TimezoneSendCount> getTimezoneSendCounts() {
//        return timezoneSendCounts;
//    }
}
