package ru.netology.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

// это конфигурационный java класс,
@Configuration
// передаем нашей аннотации, путь где лежат наши компоненты, наш контроллер
@ComponentScan("ru.netology")
@EnableWebMvc // так как наше приложение поддерживает web функции,
// данная аннотация равносильна тегу <mvc:annotation-driven/>, который находился в applicationContextMVC.xml
public class SpringConfig implements WebMvcConfigurer {
    // Осталось реализовать бины которые отвечали за конфигурацию шаблонизатора time live.

    // С помощью Spring и аннотации @Autowired, создаем ApplicationContext, его используем в бине templateResolver
    // Что бы настроить timeLeaf
    private final ApplicationContext applicationContext;

    @Autowired
    public SpringConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        // задаем папку где будут лежать наши представления
        templateResolver.setPrefix("/WEB-INF/views/");
        // задаем расширение этих представлений
        templateResolver.setSuffix(".html");
        return templateResolver;
    }


    // В данном бине так же задаем конфигурацию наших представлений
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    // Так как мы реализуем интерфейс WebMvcConfigurer, с этим интерфейсом реализовываем метод configureViewResolvers
    // Этот интерфейс реализуется, когда мы хотим настроить под себя Spring MVC,
    // Задаем шаблонизатор ThymeleafViewResolver
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        registry.viewResolver(resolver);
    }

}
