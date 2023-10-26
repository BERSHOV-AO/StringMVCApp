package ru.netology.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/first")
public class FirstController {

    // для приема HttpServletRequest - этот объект будет внедрен Spring, и в этом объекте содержатся все сведения о
    // поступающем http запросе от пользователя
//
//    public String helloPage(HttpServletRequest request) {
//
//        // в url пользователь должен будет передавать 2 параметра, имя и фамилия.
//        // Параметр name, будет иметь ключ name.
//        String name = request.getParameter("name");
//        // Параметр surname, будет иметь ключ surname.
//        String surname = request.getParameter("surname");


    //    required = false дает возможность работать без параметров, но будет null
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname) {
        System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";

    }
}
