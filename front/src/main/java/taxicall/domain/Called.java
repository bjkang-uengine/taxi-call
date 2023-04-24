package taxicall.domain;

import java.util.*;
import lombok.*;
import taxicall.domain.*;
import taxicall.infra.AbstractEvent;

@Data
@ToString
public class Called extends AbstractEvent {

    private Long id;
    private Long userid;
    private String userLocation;
    private String destination;
    private String mobileNumber;
    private String status;

    public Called(Call aggregate) {
        super(aggregate);
    }

    public Called() {
        super();
    }
}
