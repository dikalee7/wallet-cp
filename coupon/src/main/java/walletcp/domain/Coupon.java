package walletcp.domain;

import walletcp.domain.CouponPurchased;
import walletcp.CouponApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Coupon_table")
@Data

public class Coupon  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long price;
    
    
    
    
    
    private String name;
    
    
    
    
    
    private String type;
    
    
    
    
    
    private String buyer;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        CouponPurchased couponPurchased = new CouponPurchased(this);
        couponPurchased.publishAfterCommit();

    }

    public static CouponRepository repository(){
        CouponRepository couponRepository = CouponApplication.applicationContext.getBean(CouponRepository.class);
        return couponRepository;
    }



    public void cancelCoupon(){
        CouponCanceled couponCanceled = new CouponCanceled(this);
        couponCanceled.publishAfterCommit();

    }



}
