package bitcamp.java106.pms.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import bitcamp.java106.pms.service.FacebookService;

@Service
public class FacebookServiceImpl implements FacebookService {

    @Override
    public <T> T fb(String accessToken, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        
        try {
            return restTemplate.getForObject(
                    "https://graph.facebook.com/v3.0/me?access_token={v1}&fields={v2}",
                    type,
                    accessToken, "id,name,email");
            
        } catch (Exception e) {
            throw new RuntimeException(
                    "페이스북 Graph API 실행 오류!", 
                    e);
        }
    }
    
}
