package taxicall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxicall.TaxiApplication;
import taxicall.domain.Dispatched;

@Entity
@Table(name = "Taxi_table")
@Data
public class Taxi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String number;

    private String model;

    private String driverName;

    private String driverMobileNumber;

    private Long callid;

    private String status;

    private String userid;

    @PostPersist
    public void onPostPersist() {
        Dispatched dispatched = new Dispatched(this);
        dispatched.publishAfterCommit();
    }

    public static TaxiRepository repository() {
        TaxiRepository taxiRepository = TaxiApplication.applicationContext.getBean(
            TaxiRepository.class
        );
        return taxiRepository;
    }

    public void boarding() {
        Boardinged boardinged = new Boardinged(this);
        boardinged.publishAfterCommit();
    }

    public void arrival() {
        Arrivaled arrivaled = new Arrivaled(this);
        arrivaled.publishAfterCommit();
    }

    public void paymentRequest() {
        Paymented paymented = new Paymented(this);
        paymented.publishAfterCommit();
    }

    public void departure() {
        Departured departured = new Departured(this);
        departured.publishAfterCommit();
    }

    public static void duplicateCall(Called called) {
        /** Example 1:  new item 
        Taxi taxi = new Taxi();
        repository().save(taxi);

        */

        /** Example 2:  finding and process
        
        repository().findById(called.get???()).ifPresent(taxi->{
            
            taxi // do something
            repository().save(taxi);


         });
        */

    }
}
