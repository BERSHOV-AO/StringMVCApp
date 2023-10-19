package ru.netology;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    // будет один метод который будет показывать представление

    // в аннотации вы должны указать, какой метод url будет приводить в этот метод контроллера
    @GetMapping("/hello-world")
    public String sayHello() {
        // В этом методе можем:
        // - пользователя перенаправлять куда ли бо
        // - обращаться к модели
        // - доставать данные из БД, показывать пользователю
        return "hello_world"; // возвращаем необходимое представление hello_world.html - это представление должно
        // лежать в папку web-inf.views
    }
}
