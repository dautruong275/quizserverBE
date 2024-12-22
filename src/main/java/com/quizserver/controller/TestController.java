package com.quizserver.controller;

import com.quizserver.dto.QuestionDTO;
import com.quizserver.dto.TestDTO;
import com.quizserver.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class TestController {
    @Autowired
    private TestService testService;

    @PostMapping("/test")
    public ResponseEntity<?>  createTest(@RequestBody TestDTO dto){
        try {
            return new ResponseEntity<>(testService.createTest(dto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }

    @PostMapping("/question")
    public ResponseEntity<?> addQuestionInTest(@RequestBody QuestionDTO dto){
        try {
            return new ResponseEntity<>(testService.addQuestionInTest(dto), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
    @GetMapping("/test")
    public ResponseEntity<?> getAllTest(){
        try {
            return new ResponseEntity<>(testService.getAllTests(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
        }
    }
}