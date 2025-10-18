package main.property;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import main.config.YamlPropertySourceFactory;
import main.model.BoosterType;
import main.model.PlayerClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties
@PropertySource(value = "classpath:class-details.yaml", factory = YamlPropertySourceFactory.class)
public class ClassProperties {

    private List<ClassDetail> classes;


    @Data
    public static class ClassDetail {
        private PlayerClass playerClass;
        private Integer healthFactor;
        private Integer attackFactor;
        private Integer defenseFactor;
        private String bannerImg;
        private List<Booster> boosters;

        @Data
        public static class Booster {
            private String name;
            private Double value;
            private BoosterType type;
            private String icon;
        }
    }

    public ClassDetail getDetailsByPlayerClass(PlayerClass playerClass) {

        return this.classes.stream().filter(d -> d.getPlayerClass() == playerClass).findFirst().get();
    }
}
