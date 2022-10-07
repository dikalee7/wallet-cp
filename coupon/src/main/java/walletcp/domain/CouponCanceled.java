package walletcp.domain;

import walletcp.domain.*;
import walletcp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class CouponCanceled extends AbstractEvent {

    private Long id;
    private Long price;
    private String name;
    private String type;
    private String buyer;
    private String status;

    public CouponCanceled(Coupon aggregate){
        super(aggregate);
    }
    public CouponCanceled(){
        super();
    }
}
