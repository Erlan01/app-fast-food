package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Page<Product> findAllByCategoryId(Pageable pageable, Long categoryId);

    Page<Product> findAllByDiscountId(Pageable pageable, Long discountId);

    Optional<Product> findByIdAndActiveIsTrue(UUID id);
}