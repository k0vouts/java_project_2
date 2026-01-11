package pl.vistula.firstapi.product.support;

import org.springframework.stereotype.Component;
import pl.vistula.firstapi.product.api.request.ProductRequest;
import pl.vistula.firstapi.product.api.request.UpdateProductRequest;
import pl.vistula.firstapi.product.api.responce.ProductResponse;
import pl.vistula.firstapi.product.domain.Product;

@Component
public class ProductMapper {

    public Product toProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName());
    }

    public ProductResponse toProductResponse(Product product, UpdateProductRequest request) {
        product.setName(request.getName());
        return new ProductResponse(product.getId(), product.getName());
    }
}
