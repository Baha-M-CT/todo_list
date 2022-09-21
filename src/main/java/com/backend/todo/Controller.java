package com.backend.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    private final List<String> tasks = new ArrayList<>();

    @GetMapping("/tasks")
    public String getTasks() {
        return tasks.toString();
    }

    @PostMapping("/task")
    public void createTask(@RequestParam String text) {
        tasks.add(text);
    }

}
