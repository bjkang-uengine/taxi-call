package taxicall.domain;

import java.util.*;
import lombok.*;
import taxicall.domain.*;
import taxicall.infra.AbstractEvent;

@Data
@ToString
public class Accumulationed extends AbstractEvent {

    private Long id;
    private String userid;
    private String status;
    private String point;
}
