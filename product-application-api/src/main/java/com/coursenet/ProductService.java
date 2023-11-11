package com.coursenet;

import com.coursenet.model.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO getProduct(long id);
    void insertProduct(ProductDTO product);
    void updateProduct(long id, ProductDTO product);
    void updateProductPrice(long id, ProductDTO product);
    void deleteProduct(long id);
    List<ProductDTO> getProducts();
}
