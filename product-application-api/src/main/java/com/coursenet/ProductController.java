package com.coursenet;

import com.coursenet.model.GenericResponse;
import com.coursenet.model.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {
    ResponseEntity<ProductDTO> getProduct(long id);
    ResponseEntity<GenericResponse> insertProduct(ProductDTO product);
    ResponseEntity<GenericResponse> updateProduct(long id, ProductDTO product);
    ResponseEntity<GenericResponse> updateProductPrice(long id, ProductDTO product);
    ResponseEntity<GenericResponse> deleteProduct(long id);
    ResponseEntity<List<ProductDTO>> getProducts();
}
