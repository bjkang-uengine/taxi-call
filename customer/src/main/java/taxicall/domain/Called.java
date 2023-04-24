package taxicall.domain;

import java.util.*;
import lombok.Data;
import taxicall.infra.AbstractEvent;

@Data
public class Called extends AbstractEvent {

    private Long id;
    private Long userid;
    private String user_location;
    private String destination;
    private String mobile_number;
    private String status;
}
