package com.example.ChocolateShopV2.controller;

import com.example.ChocolateShopV2.dto.product.ProductAddRequest;
import com.example.ChocolateShopV2.dto.product.ProductResponse;
import com.example.ChocolateShopV2.dto.purveyor.PurveyorSettingRequest;
import com.example.ChocolateShopV2.service.ProductService;
import com.example.ChocolateShopV2.service.PurveyorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/management/product")
public class ProductController {
    private final ProductService productService;
    private final PurveyorService purveyorService;
    @PostMapping("/add")
    public void add(@RequestBody ProductAddRequest request){
        productService.add(request);
    }
    @PostMapping("/set_purveyor")
    public void set_purveyor(@RequestBody PurveyorSettingRequest request){
        productService.set_purveyor(request);
        purveyorService.set_product(request);
    }
    @GetMapping("/show/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }
}
