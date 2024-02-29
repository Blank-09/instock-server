package com.aspirecoders.instock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
// import org.springframework.web.bind.annotation.CrossOrigin;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> 0a3ff260198b430d0df515ac66d7b63ad93429aa
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.enums.OrderStatus;
import com.aspirecoders.instock.model.Order;
import com.aspirecoders.instock.service.OrderService;

@RestController
<<<<<<< HEAD
// @CrossOrigin(origins = "http://localhost:5173/")
=======
@CrossOrigin(origins = "http://localhost:5173")
>>>>>>> 0a3ff260198b430d0df515ac66d7b63ad93429aa
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("")
    public List<Order> getDetails() {
        return orderService.getOrder();
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable long id) {
        return orderService.getById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> postMethod(@RequestBody Order inv) {
        if (orderService.addOrder(inv)) {
            return new ResponseEntity<>(inv, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(inv, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Order> putMethodName(@PathVariable int id, @RequestBody Order entity) {
        return new ResponseEntity<>(orderService.editOrder(id, entity), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMethod(@PathVariable long id) {
        if (orderService.deleteById(id)) {
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.internalServerError().body("Deletion aborted");
    }

    @GetMapping("/count/{status}")
    public int getMethodName(@PathVariable OrderStatus status) {
        return orderService.getCount(status);
    }

}