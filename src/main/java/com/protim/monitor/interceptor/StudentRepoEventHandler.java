package com.protim.monitor.interceptor;

import com.protim.monitor.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@Slf4j
@RepositoryEventHandler
public class StudentRepoEventHandler {

    @HandleBeforeCreate
    public void handleStudentCreate(Student s){
        log.info("Going to create this resource into database: " + s.toString());
    }

    @HandleBeforeSave
    public void handleStudentSave(Student s){
        log.info("Going to save this resource into database: " + s.toString());
    }

    @HandleBeforeDelete
    public void handleStudentDelete(Student s){
        log.info("Going to delete this resource into database: " + s.toString());
    }
}
