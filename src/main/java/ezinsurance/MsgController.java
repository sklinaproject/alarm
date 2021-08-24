package ezinsurance;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 @RestController
 public class MsgController {


    @Autowired
    MsgRepository msgRepository;

    @RequestMapping(value = "/msgs/getMsgs", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getMyalarms(@RequestBody HashMap<String, Object> userMap) {
        
		System.out.println("\n\n##### getMsgs userMap : " + userMap + "\n\n");

		String  custNm = (String)userMap.get("custNm"); //

		Map<String, Object> result = new HashMap<>();

		List<Msg> msgs = new ArrayList<>();

		if(StringUtils.isEmpty(custNm)) {
			Iterable<Msg> mypageIt = msgRepository.findAll();

			if( mypageIt!= null)
			{
				mypageIt.forEach(msgs::add);
			}

		}
		else {
			msgs = msgRepository.findByCustNm(custNm);
		}

		result.put("data", msgs);
        
		return ResponseEntity.ok().body(result);
    }
	
    
 }
