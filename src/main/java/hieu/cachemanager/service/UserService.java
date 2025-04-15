package hieu.cachemanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Cacheable("users")
    public String getUserDetails(String userId) {
        // Simulate a remote API call
        String url = "https://jsonplaceholder.typicode.com/users/" + userId;
        return restTemplate.getForObject(url, String.class);
    }
}
