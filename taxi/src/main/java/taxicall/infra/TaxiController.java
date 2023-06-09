package taxicall.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taxicall.domain.*;

@RestController
// @RequestMapping(value="/taxis")
@Transactional
public class TaxiController {

    @Autowired
    TaxiRepository taxiRepository;

    @RequestMapping(
        value = "taxis/{id}/택시탑승",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi boarding(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/boarding  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.boarding();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/목적지도착",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi arrival(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/arrival  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.arrival();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/결제요청",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi paymentRequest(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/paymentRequest  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.paymentRequest();

        taxiRepository.save(taxi);
        return taxi;
    }

    @RequestMapping(
        value = "taxis/{id}/출발",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Taxi departure(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /taxi/departure  called #####");
        Optional<Taxi> optionalTaxi = taxiRepository.findById(id);

        optionalTaxi.orElseThrow(() -> new Exception("No Entity Found"));
        Taxi taxi = optionalTaxi.get();
        taxi.departure();

        taxiRepository.save(taxi);
        return taxi;
    }
}
