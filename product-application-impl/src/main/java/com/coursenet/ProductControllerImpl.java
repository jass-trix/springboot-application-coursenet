package com.coursenet;


import com.coursenet.model.GenericResponse;
import com.coursenet.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = "application/json")
public class ProductControllerImpl implements ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(value = "id") long id) {
        ProductDTO productDTO = productService.getProduct(id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping(consumes = "application/json")
    @Override
    public ResponseEntity<GenericResponse> insertProduct(@RequestBody ProductDTO product) {
        productService.insertProduct(product);
        return ResponseEntity.ok(new GenericResponse(true, "Product inserted"));
    }

    @PutMapping(value = "/{id}", consumes = "application/json")
    @Override
    public ResponseEntity<GenericResponse> updateProduct(@PathVariable(value = "id") long id, @RequestBody ProductDTO product) {
        productService.updateProduct(id, product);
        return ResponseEntity.ok(new GenericResponse(true, "Product updated"));
    }

    @PatchMapping(value = "/{id}", consumes = "application/json")
    @Override
    public ResponseEntity<GenericResponse> updateProductPrice(@PathVariable(value = "id")long id, @RequestBody ProductDTO product) {
        productService.updateProductPrice(id, product);
        return ResponseEntity.ok(new GenericResponse(true, "Product price updated"));
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<GenericResponse> deleteProduct(@PathVariable(value = "id") long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(new GenericResponse(true, "Product deleted"));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }
}
