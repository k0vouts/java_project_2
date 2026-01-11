package pl.vistula.firstapi.product.support;

import org.springframework.stereotype.Component;
import pl.vistula.firstapi.product.api.request.ProductRequest;
import pl.vistula.firstapi.product.api.request.UpdateProductRequest;
import pl.vistula.firstapi.product.api.responce.ProductResponse;
import pl.vistula.firstapi.product.domain.Product;

@Component
public class ProductMapper {

    // Method 1: Convert ProductRequest to Product (for POST)
    public Product toProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        return product;
    }

    // Method 2: Convert Product to ProductResponse (for GET/POST/PUT)
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }

    // Method 3: Update Product and return ProductResponse (for PUT)
    public ProductResponse toProductResponse(Product product, UpdateProductRequest request) {
        product.setName(request.getName());
        return new ProductResponse(product.getId(), product.getName());
    }
}
