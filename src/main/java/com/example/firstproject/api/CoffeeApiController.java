package com.example.firstproject.api;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoffeeApiController {
    @Autowired
    private CoffeeService coffeeService;

    //GET
    @GetMapping("/api/coffees")
    public List<Coffee>index(){
        return coffeeService.index();
    }
    @GetMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> show(@PathVariable Long id){
       Coffee coffee = coffeeService.show(id);
       return (coffee != null) ? ResponseEntity.status(HttpStatus.OK).body(coffee)
               : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //POST
    @PostMapping("/api/coffees")
    public ResponseEntity<Coffee> create(@RequestBody CoffeeDto dto){
        Coffee created = coffeeService.create(dto);
        return (created != null) ? ResponseEntity.status(HttpStatus.OK).body(created)
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //PATCH
    @PatchMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> update(@PathVariable Long id, @RequestBody CoffeeDto dto){
       Coffee updated = coffeeService.update(id, dto);
       return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated)
               : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //DELETE
    @DeleteMapping("/api/coffees/{id}")
    public ResponseEntity<Coffee> delete(@PathVariable Long id){
       Coffee deleted = coffeeService.delete(id);
       return (deleted != null) ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
               : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


}
