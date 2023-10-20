package ru.netology.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// За счет данного класс убираем файл web.xml, и всю реализацию Spring mvc через xml
public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // Данный метод мы использовать не будем, возвращаем null
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // здесь укажем класс конфигурации, который будет заменять applicationContextMVC.xml
    @Override
    protected Class<?>[] getServletConfigClasses() {
        // Подставляем класс с конфигурацией
        return new Class[]{SpringConfig.class};
    }


    // в данном методе возвращаем /
    // как в файле xml посылали на диспетчер сервлет <servlet-mapping>
    //        <servlet-name>dispatcher</servlet-name>
    //        <url-pattern>/</url-pattern>
    //    </servlet-mapping>
    @Override
    protected String[] getServletMappings() {
//        посылаем на /, все запросы от пользователя посылаем на dispatcher servlet
        return new String[]{"/"};
    }
}
