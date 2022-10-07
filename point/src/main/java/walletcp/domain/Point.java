package walletcp.domain;

import walletcp.domain.PointsDeducted;
import walletcp.PointApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name="Point_table")
@Data

public class Point  {

    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long amount;
    
    
    
    
    
    private String holder;

    @PostPersist
    public void onPostPersist(){


        PointsDeducted pointsDeducted = new PointsDeducted(this);
        pointsDeducted.publishAfterCommit();

    }

    public static PointRepository repository(){
        PointRepository pointRepository = PointApplication.applicationContext.getBean(PointRepository.class);
        return pointRepository;
    }




    public static void usePoint(CouponPurchased couponPurchased){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointsDeducted pointsDeducted = new PointsDeducted(point);
        pointsDeducted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(couponPurchased.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointsDeducted pointsDeducted = new PointsDeducted(point);
            pointsDeducted.publishAfterCommit();

         });
        */

        
    }
    public static void addPoint(CouponCanceled couponCanceled){

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        PointsDeducted pointsDeducted = new PointsDeducted(point);
        pointsDeducted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(couponCanceled.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            PointsDeducted pointsDeducted = new PointsDeducted(point);
            pointsDeducted.publishAfterCommit();

         });
        */

        
    }


}
