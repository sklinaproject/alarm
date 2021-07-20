package ezinsurance;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Data
@Entity
@Table(name="TBMSAMS001")
public class Msg {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cust_no")
    String custNo        ;    //고객번호

    @Column(name = "cust_nm")
    String custNm        ;    //고객명

    private String message;
    private String sendDtm; // 전송일시

}
