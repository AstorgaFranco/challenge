package org.example.service;


import org.example.model.DtoTask;
import org.example.model.Task;
import org.example.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateDescAndPrior {
    @Autowired(required = true)
    TaskRepository taskRepository;

    public ResponseEntity<Object> updateTask(DtoTask task, Long id) {
        System.out.println("aca updaservice");

     if (task != null && (id != null && id >= 0)   ){
         if(!task.getDescription().equals("")&& task.getPriority()!= null){
             Optional<Task>task1 = taskRepository.findById(id);

             if (task1.isPresent()) {
                 Task updateTask =  taskRepository.findById(id).get();
                 updateTask.setDescription(task.getDescription());
                 updateTask.setPriority(task.getPriority());
                 taskRepository.save(updateTask);
                 return  ResponseEntity.status(HttpStatus.CREATED).body(task);
             }else {
                return this.taskNotExist();
             }
         }else {
            return this.descriptionIsEmty();
         }
     }


        return new ResponseEntity<>("Task description is required", HttpStatus.BAD_REQUEST);



    }

    public ResponseEntity<Object> taskNotExist(){

       // return ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body("Cannot find task with given id");
        return new ResponseEntity<>("Cannot find task with given id", HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<Object> descriptionIsEmty(){
      //  return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body("Task description is required");
        return new ResponseEntity<>("Task description is required", HttpStatus.BAD_REQUEST);

    }
}
