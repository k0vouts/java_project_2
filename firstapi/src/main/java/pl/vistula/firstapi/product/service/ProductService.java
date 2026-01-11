package pl.vistula.firstapi.product.service;

import org.springframework.stereotype.Service;
import pl.vistula.firstapi.product.api.request.ProductRequest;
import pl.vistula.firstapi.product.api.responce.ProductResponse;
import pl.vistula.firstapi.product.api.request.UpdateProductRequest;

import pl.vistula.firstapi.product.domain.Product;
import pl.vistula.firstapi.product.repository.ProductRepository;
import pl.vistula.firstapi.product.support.ProductMapper;
import pl.vistula.firstapi.product.support.ProductExceptionSupplier;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(id);
    }


    public ProductResponse create(ProductRequest productRequest) {
        Product product = productMapper.toProduct(productRequest);
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductResponse(savedProduct);
    }
    public ProductResponse update(Long id, UpdateProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductExceptionSupplier.productNotFound(id));

        product.setName(request.getName());
        Product updatedProduct = productRepository.save(product);

        return productMapper.toProductResponse(updatedProduct);
    }
}
