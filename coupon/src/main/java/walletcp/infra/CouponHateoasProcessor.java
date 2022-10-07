package walletcp.infra;
import walletcp.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class CouponHateoasProcessor implements RepresentationModelProcessor<EntityModel<Coupon>>  {

    @Override
    public EntityModel<Coupon> process(EntityModel<Coupon> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/cancelcoupon").withRel("cancelcoupon"));

        
        return model;
    }
    
}
