package com.semicolon.africa.data.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.semicolon.africa.data.dtos.request.CreatedPostRequest;
import com.semicolon.africa.data.dtos.responses.ApiResponse;
import com.semicolon.africa.data.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
@CrossOrigin("*")
@Controller
public class PostController {

    private PostServiceImpl service;

    @Autowired @Lazy public void SetPostService(PostServiceImpl service) {
        this.service = service;
    }

    @PostMapping("api/v1/post")
    public ResponseEntity<?> createPost(@RequestBody CreatedPostRequest postRequest){
        try{
            System.out.println(postRequest);
             Object response = service.createPost(postRequest.getTitle(), postRequest.getContent());
             return new ResponseEntity<>(new ApiResponse<>(response, true), HttpStatus.CREATED);

        } catch(Exception error){
            return new ResponseEntity<>(new ApiResponse<>(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("api/v1/update")
    public ResponseEntity<ApiResponse> editPost(String title, String content){
        try{
            String response = service.editPost(title, content);
            return new ResponseEntity<>(new ApiResponse<>(response, true), HttpStatus.CREATED);
        } catch(Exception error){
            return new ResponseEntity<>(new ApiResponse<>(error.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    private static JsonNode toJson(String src) throws IOException {
        return getDefaultObjectMapper().readTree(src);
    }
}
