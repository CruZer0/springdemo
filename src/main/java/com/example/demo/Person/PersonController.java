package com.example.demo.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
@ResponseBody
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonRepository repository;

    @PostMapping
    public void postPerson(@RequestBody String body){
        Person person = new Gson().fromJson(body, Person.class);
        repository.insert(person);
    }
    @GetMapping("/{id}")
    public String getPerson(@PathVariable String id){
        Person person = repository.findById(id).get();
        return new Gson().toJson(person);
    }
}
