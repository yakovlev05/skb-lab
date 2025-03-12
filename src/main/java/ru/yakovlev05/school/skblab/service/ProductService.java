package ru.yakovlev05.school.skblab.service;

import org.springframework.stereotype.Service;
import ru.yakovlev05.school.skblab.dto.ProductIn;
import ru.yakovlev05.school.skblab.dto.ProductOut;
import ru.yakovlev05.school.skblab.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final static List<Product> DATABASE = new ArrayList<>();

    public ProductOut addProduct(ProductIn productIn) {
        Product product = Product.builder()
                .id(DATABASE.size()+1L)
                .price(productIn.getPrice())
                .date(productIn.getInfo().getDate())
                .build();

        DATABASE.add(product);

        return toDto(product);
    }

    private ProductOut toDto(Product product) {
        ProductOut productOut = new ProductOut();
        ProductOut.Info productOutInfo= new ProductOut.Info();

        productOutInfo.setId(product.getId());
        productOutInfo.setDate(product.getDate());

        productOut.setPrice(product.getPrice());
        productOut.setInfo(productOutInfo);

        return productOut;
    }

}
