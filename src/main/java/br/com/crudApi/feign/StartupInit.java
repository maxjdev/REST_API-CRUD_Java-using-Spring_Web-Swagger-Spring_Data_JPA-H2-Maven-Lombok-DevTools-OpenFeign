package br.com.crudApi.feign;

import br.com.crudApi.model.User;
import br.com.crudApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author maxjdev
 */

@Component
public class StartupInit implements CommandLineRunner {
    private final RandomUserFeign userFeign;
    private final UserService service;
    @Autowired
    public StartupInit(RandomUserFeign randomUserFeign, UserService userService) {
        this.userFeign = randomUserFeign;
        this.service = userService;
    }

    @Override
    public void run(String... args) {
        Map<String, Object> userData = userFeign.getRandomUser();
        List<Map<String, Object>> results = (List<Map<String, Object>>) userData.get("results");
        Map<String, Object> userResult = results.get(0);
        String firstName = ((Map<String, String>) userResult.get("name")).get("first");
        String email = (String) userResult.get("email");

        User user = new User();
        user.setUsername(firstName);
        user.setEmail(email);
        System.out.println("NEW USER: " + user);
        service.createUser(user);
    }
}
