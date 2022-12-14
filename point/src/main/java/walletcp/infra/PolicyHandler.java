package walletcp.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import walletcp.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import walletcp.domain.*;


@Service
@Transactional
public class PolicyHandler{
    @Autowired PointRepository pointRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponPurchased'")
    public void wheneverCouponPurchased_UsePoint(@Payload CouponPurchased couponPurchased){

        CouponPurchased event = couponPurchased;
        System.out.println("\n\n##### listener UsePoint : " + couponPurchased + "\n\n");


        

        // Sample Logic //
        Point.usePoint(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='CouponCanceled'")
    public void wheneverCouponCanceled_AddPoint(@Payload CouponCanceled couponCanceled){

        CouponCanceled event = couponCanceled;
        System.out.println("\n\n##### listener AddPoint : " + couponCanceled + "\n\n");


        

        // Sample Logic //
        Point.addPoint(event);
        

        

    }

}


