package org.example.config;

import org.example.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//标识这是一个配置类
@Configuration
//引入配置文件
//@ImportResource("classpath:aaa.xml")
//@EnableConfigurationProperties(User.class)  1.开启User配置绑定功能 2.把User这个组件自动注册到容器中
//上面这个注解效果同在User类中加上@Component 和 @ConfigurationProperties("user1")
//但当我们引入第三方的类时如果第三方类中没有@component注解则@ConfigurationProperties("user1")也不会生效，这时我们可以采用在配置类中加上上面这个注解
public class MyConfig {

//    给容器添加组件，组件id就是方法名，方法类型就是组件类型，返回的值就是组件在容器中的实例
//    @Bean("user")也可以通过这种方式给组件起名字
    @Bean
    public User user01(){
        return new User(1,"a");
    }
}
