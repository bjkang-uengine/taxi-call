package taxicall.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import taxicall.FrontApplication;
import taxicall.domain.Called;

@Entity
@Table(name = "Call_table")
@Data
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userid;

    private String userLocation;

    private String destination;

    private String status;

    @PostPersist
    public void onPostPersist() {
        Called called = new Called(this);
        called.publishAfterCommit();
    }

    public static CallRepository repository() {
        CallRepository callRepository = FrontApplication.applicationContext.getBean(
            CallRepository.class
        );
        return callRepository;
    }

    public void cancel(CancelCommand cancelCommand) {
        Canceled canceled = new Canceled(this);
        canceled.publishAfterCommit();
    }

    public static void updateTaxiInfo(Dispatched dispatched) {
        /** Example 1:  new item 
        Call call = new Call();
        repository().save(call);

        */

        /** Example 2:  finding and process
        
        repository().findById(dispatched.get???()).ifPresent(call->{
            
            call // do something
            repository().save(call);


         });
        */

    }

    public static void updateStatus(Departured departured) {
        /** Example 1:  new item 
        Call call = new Call();
        repository().save(call);

        */

        /** Example 2:  finding and process
        
        repository().findById(departured.get???()).ifPresent(call->{
            
            call // do something
            repository().save(call);


         });
        */

    }
}
