package nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author :     ring2
 * @date :       2020/3/28 08:49
 * description:
 **/
@ConfigurationProperties(prefix = "people")
@Component
@RefreshScope
public class User {
    int age;
    String name;
    public String getName() {
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge(){
        return age;
    }


}
