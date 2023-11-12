package com.coursenet;

import com.coursenet.model.GenericResponse;
import com.coursenet.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/v2/products")
public class ProductControllerV2 implements ProductController {
    @Override
    public ResponseEntity<ProductDTO> getProduct(long id) {
        // service v2
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> insertProduct(ProductDTO product) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> updateProduct(long id, ProductDTO product) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> updateProductPrice(long id, ProductDTO product) {
        return null;
    }

    @Override
    public ResponseEntity<GenericResponse> deleteProduct(long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return null;
    }
}
