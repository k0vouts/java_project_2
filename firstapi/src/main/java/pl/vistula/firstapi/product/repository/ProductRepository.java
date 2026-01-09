package pl.vistula.firstapi.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.vistula.firstapi.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}