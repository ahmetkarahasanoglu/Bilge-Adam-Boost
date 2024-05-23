package com.ahmet.Java6XmlConfiguration.iocwithannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration // ayarların burda olduğunu bildiriyoruz.
@ComponentScan("com.ahmet.Java6XmlConfiguration.iocwithannotation") // iocwithannotation paketinin içinde tarasın. || IocConfig class'ımızı annotationContext.xml dosyası yerine kullanıyoruz.
public class IocConfigWA {



}
