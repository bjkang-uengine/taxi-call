package taxicall.domain;

import java.util.*;
import lombok.*;
import taxicall.domain.*;
import taxicall.infra.AbstractEvent;

@Data
@ToString
public class Dispatched extends AbstractEvent {

    private Long id;
    private String number;
    private String model;
    private String driverName;
    private String driverMobileNumber;
    private Long callid;
    private String status;
    private String userid;

    public Dispatched(Taxi aggregate) {
        super(aggregate);
    }

    public Dispatched() {
        super();
    }
}
