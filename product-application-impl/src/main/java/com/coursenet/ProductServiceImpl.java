package com.coursenet;

import com.coursenet.model.Product;
import com.coursenet.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryJPA productRepository;

    @Override
    public ProductDTO getProduct(long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return null;
        }

        return new ProductDTO(
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    @Override
    public void insertProduct(ProductDTO product) {
        Product newProduct = new Product(
                product.getName(),
                product.getPrice(),
                product.getDescription()
        );
        productRepository.save(newProduct);
    }

    @Override
    public void updateProduct(long id, ProductDTO product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return;
        }

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
    }

    @Override
    public void updateProductPrice(long id, ProductDTO product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return;
        }

        existingProduct.setPrice(product.getPrice());
        productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            return;
        }

        productRepository.delete(existingProduct);
    }

    @Override
    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(new ProductDTO(
                    product.getName(),
                    product.getDescription(),
                    product.getPrice()
            ));
        }
        return productDTOs;
    }
}
