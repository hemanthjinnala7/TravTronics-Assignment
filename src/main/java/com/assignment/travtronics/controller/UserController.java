package com.assignment.travtronics.controller;

import com.assignment.travtronics.model.ProductModel;
import com.assignment.travtronics.model.UserModel;
import com.assignment.travtronics.repository.ProductRepository;
import com.assignment.travtronics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@RequestMapping("/api/user")

@RestController
    public class UserController{
        @Autowired
        ProductRepository productRepository;
        @Autowired
        UserRepository userRepository;
        @PostMapping("/Register")
        public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel)
        {
            try
            {
                UserModel userObj = userRepository.save(userModel);
                return new ResponseEntity<>(userObj, HttpStatus.CREATED);
            }
            catch (Exception e)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        @PostMapping("/addItemToCartById/{userId}/{productId}")
        public ResponseEntity<UserModel> addItemToCartById(@PathVariable Long userId, @PathVariable Long productId)
        {
            try
            {
                Optional<UserModel> userOpt = userRepository.findById(userId);
                Optional<ProductModel> productOpt = productRepository.findById(productId);
                if (userOpt.isPresent() && productOpt.isPresent())
                {
                    UserModel user = userOpt.get();
                    ProductModel product = productOpt.get();
                    if (user.getCart() == null)
                    {
                        user.setCart(new ArrayList<>());
                    }
                    user.getCart().add(product);
                    UserModel updatedUser = userRepository.save(user);
                    return new ResponseEntity<>(updatedUser, HttpStatus.OK);
                }
                else
                {
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
            catch (Exception e)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    @PostMapping("/Orderitem/{userId}/{productId}")
    public ResponseEntity<UserModel> Orderitem(@PathVariable Long userId, @PathVariable Long productId)
    {
        try
        {
            Optional<UserModel> userOpt = userRepository.findById(userId);
            Optional<ProductModel> productOpt = productRepository.findById(productId);
            if (userOpt.isPresent() && productOpt.isPresent())
            {
                UserModel user = userOpt.get();
                ProductModel product = productOpt.get();
                if (user.getCart() == null)
                {
                    user.setCart(new ArrayList<>());
                }
                user.getOrders().add(product);
                UserModel updatedUser = userRepository.save(user);
                return new ResponseEntity<>(updatedUser, HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}












