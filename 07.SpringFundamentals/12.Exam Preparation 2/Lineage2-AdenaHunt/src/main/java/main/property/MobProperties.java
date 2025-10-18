package main.property;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import main.config.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:mob-details.yaml", factory = YamlPropertySourceFactory.class)
public class MobProperties {

    private List<MobDetail> mobs;

    @Data
    public static class MobDetail {
        private String name;
        private List<Integer> levelRange;
        private String spawnArea;
        private String description;
        private String image;
        private Double healthFactor;
        private Double attackFactor;
        private Double defenseFactor;
        private List<Integer> adenaDrop;
        private List<Integer> xpDrop;
    }
    @PostConstruct
    public void init() {
        System.out.println();
    }
}
