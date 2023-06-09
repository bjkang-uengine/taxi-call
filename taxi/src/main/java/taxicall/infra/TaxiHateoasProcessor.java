package taxicall.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import taxicall.domain.*;

@Component
public class TaxiHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Taxi>> {

    @Override
    public EntityModel<Taxi> process(EntityModel<Taxi> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/택시탑승")
                .withRel("택시탑승")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/목적지도착")
                .withRel("목적지도착")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/결제요청")
                .withRel("결제요청")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/출발")
                .withRel("출발")
        );

        return model;
    }
}
