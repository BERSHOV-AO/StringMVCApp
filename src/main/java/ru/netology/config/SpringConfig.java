package ru.netology.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// это конфигурационный java класс,
@Configuration
// передаем нашей аннотации, путь где лежат наши компоненты, наш контроллер
@ComponentScan("ru.netology")
@EnableWebMvc // так как наше приложение поддерживает web функции,
// данная аннотация равносильна тегу <mvc:annotation-driven/>, который находился в applicationContextMVC.xml
public class SpringConfig {
    // Осталось реализовать бины которые отвечали за конфигурацию шаблонизатора time live.

}
