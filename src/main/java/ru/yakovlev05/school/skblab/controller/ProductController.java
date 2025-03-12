package ru.yakovlev05.school.skblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yakovlev05.school.skblab.dto.ProductIn;
import ru.yakovlev05.school.skblab.dto.ProductOut;
import ru.yakovlev05.school.skblab.exception.BadGatewayException;
import ru.yakovlev05.school.skblab.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductOut addProduct(@RequestBody ProductIn productIn) {
        return productService.addProduct(productIn);
    }

    @GetMapping("/502")
    public void getCode502() {
        throw new BadGatewayException("Bad Gateway");
    }
}
