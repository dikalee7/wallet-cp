package walletcp.domain;

import walletcp.domain.*;
import walletcp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PointsDeducted extends AbstractEvent {

    private Long id;
    private Long amount;
    private String holder;

    public PointsDeducted(Point aggregate){
        super(aggregate);
    }
    public PointsDeducted(){
        super();
    }
}
