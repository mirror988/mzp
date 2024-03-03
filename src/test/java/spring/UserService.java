package spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Value("${date:}")
    String date;

    public void getDate() {
        System.out.println(date);
    }
}
