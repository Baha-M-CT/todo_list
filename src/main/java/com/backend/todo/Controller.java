package com.backend.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;


@RestController
public class Controller {

    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/tasks")
    public String getTasks() {
        String result = "[";
        for (Task task : tasksRepository.findAll()) {
            if (result.length() > 1) {
                result += ",";
            }
            result += "\"" + task.getText() + "\"";
        }
        return result + "]";
    }

    @PostMapping("/task")
    public String  createTask(@RequestParam String text) {

        Task task = new Task();
        task.setText(text);
        tasksRepository.save(task);
        return "Task created";

    }

}
