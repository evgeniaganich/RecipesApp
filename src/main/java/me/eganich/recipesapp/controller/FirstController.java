package me.eganich.recipesapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String helloWorld() {
        return "Приложение запущено";
    }
    @GetMapping("/info")
    public String getProjectInfo() {
        return "Имя ученика: Ганич Евгения<br>Название проекта: Приложение для сайта рецептов<br> Дата создания: 09.12.2022<br>Описание проекта: " +
                "Приложение для работы с сайтом рецептов, написано на Java с использованием Spring и Maven";
    }
}

