package org.gulingjingguai.mzp.lesson.runoob.basicStage;

/**
 * transient 修饰的关键字不参与序列化与反序列化
 * 防止敏感信息在网络中传输
 */
public class UseTransient {
    private String name;
    private transient String password;

    public UseTransient(String name, String pwd) {
        this.name = name;
        this.password = pwd;
    }
}
