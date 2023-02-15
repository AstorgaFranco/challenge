package org.example.controller;

import org.example.model.DtoTask;
import org.example.service.UpdateDescAndPrior;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("http://localhost:8081")
@RequestMapping
@RestController
public class controller {
    @Autowired(required = true)
    UpdateDescAndPrior updateDescAndPrior;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value = "greeting", method = RequestMethod.GET)
    public ResponseEntity<String> getResult() {
        System.out.println("puto");

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> setStatusAplication(@RequestBody(required = false) DtoTask task, @PathVariable(required = false) Long id)  {
        System.out.println("puto");
        return  updateDescAndPrior.updateTask(task,id);


    }
}
