package org.gulingjingguai.mzp.lesson.hsp;

public class UserServiceImpl implements UserService{

    @Override
    public void readBook() {
        System.out.println("读书");
        rentingHouse();
    }

    @Override
    public void rentingHouse() {
        System.out.println("租房子");
    }
}
