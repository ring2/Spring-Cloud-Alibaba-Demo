package nacos;

import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;
import nacos.config.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author :     ring2
 * @date :       2020/3/27 23:59
 * description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerApplication {

    @Autowired
    User user;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/nacos/rpc/{string}")
    public String test(@PathVariable String string) {
        string = restTemplate().getForObject("http://provider:8080/echo/"+string,String.class);
        return "rpc" + string;
    }

    @RestController
    @RefreshScope
    class consumer{

        @Value("${consumer.config}")
        String config;

        @GetMapping("/config")
        public String getConfig(){
            return config;
        }
    }


}
