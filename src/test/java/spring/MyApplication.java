package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        UserService userService = applicationContext.getBean(UserService.class);
        userService.getDate();
    }
}
