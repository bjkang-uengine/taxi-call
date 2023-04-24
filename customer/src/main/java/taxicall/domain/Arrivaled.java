package taxicall.domain;

import java.util.*;
import lombok.Data;
import taxicall.infra.AbstractEvent;

@Data
public class Arrivaled extends AbstractEvent {

    private Long id;
    private String number;
    private String model;
    private String driverName;
    private String driverMobileNumber;
    private Long callid;
    private String status;
    private String userid;
}
