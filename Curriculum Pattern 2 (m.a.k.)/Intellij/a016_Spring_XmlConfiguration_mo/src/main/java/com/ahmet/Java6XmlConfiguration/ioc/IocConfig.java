package com.ahmet.Java6XmlConfiguration.ioc;

import com.ahmet.Java6XmlConfiguration.xml.GameRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // ayarların burda olduğunu bildiriyoruz.
@ComponentScan("com.ahmet.Java6XmlConfiguration.ioc") // ioc paketinin içinde tarasın. || IocConfig class'ımızı annotationContext.xml dosyası yerine kullanıyoruz.
public class IocConfig {

    @Bean
    public String name() {
        return "Mustafa";
    }

    @Bean
    @Primary
    public IGameConsoleIoc mymario() {
        return new MarioGameIoC();
    }

    @Bean
    public IGameConsoleIoc mypacman() {
        return new PacmanIoC();
    }

    @Bean
    IGameConsoleIoc mysupercontra() {
        return new SuperContraIoC();
    }

    @Bean
    public GameRunnerIoC gameRunner() {
        return new GameRunnerIoC(mypacman());
    }

}
