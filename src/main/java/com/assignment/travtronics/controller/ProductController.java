package com.assignment.travtronics.controller;


import com.assignment.travtronics.model.ProductModel;
import com.assignment.travtronics.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
    public class ProductController
    {

        @Autowired
        ProductRepository productRepository;


        @GetMapping("/getAllProducts")
        public ResponseEntity<List<ProductModel>> getAllProducts()
        {
            try
            {
                List<ProductModel> cartList = new ArrayList<>();
                productRepository.findAll().forEach(cartList::add);

                if (cartList.isEmpty())
                {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(cartList, HttpStatus.OK);
            }
            catch (Exception ex)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        @GetMapping("/getProductById/{id}")
        public ResponseEntity<ProductModel> getProductById(@PathVariable Long id)
        {
            Optional<ProductModel> cartObj = productRepository.findById(id);
            if (cartObj.isPresent())
            {
                return new ResponseEntity<>(cartObj.get(), HttpStatus.OK);
            } else
            {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }

        @PostMapping("admin/addProduct")
        public ResponseEntity<ProductModel> addProduct(@RequestBody ProductModel productModel)
        {
            try {
                ProductModel cartObj = productRepository.save(productModel);
                return new ResponseEntity<>(cartObj, HttpStatus.CREATED);
            }
            catch (Exception e)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @PostMapping("admin/updateProduct/{id}")
        public ResponseEntity<ProductModel> updateProduct(@PathVariable Long id, @RequestBody ProductModel productModel)
        {
            try
            {
                Optional<ProductModel> existingProductData = productRepository.findById(id);
                if (existingProductData.isPresent())
                {
                    ProductModel updatedProductData = existingProductData.get();
                    if (productModel.getName() != null)
                    {
                        updatedProductData.setName(productModel.getName());
                    }
                    if (productModel.getPrice() != null && !productModel.getPrice().isEmpty())
                    {
                        updatedProductData.setPrice(productModel.getPrice());
                    }
                    if (productModel.getType() != null)
                    {
                        updatedProductData.setType(productModel.getType());
                    }
                    if (productModel.getGender() != null && !productModel.getGender().isEmpty())
                    {
                        updatedProductData.setGender(productModel.getGender());
                    }
                    ProductModel updatedProduct = productRepository.save(updatedProductData);
                    return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
                }

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }



        @DeleteMapping("admin/deleteProductById/{id}")
        public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id)
        {
            try
            {
                productRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (Exception e)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping("admin/deleteAllProducts")
        public ResponseEntity<HttpStatus> deleteAllProducts()
        {
            try
            {
                productRepository.deleteAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            catch (Exception e)
            {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }




