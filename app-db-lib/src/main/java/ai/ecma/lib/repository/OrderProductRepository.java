package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Order;
import ai.ecma.lib.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID> {
    Optional<OrderProduct> findByOrderIdAndProductId(UUID orderId, UUID productId);

    List<OrderProduct> findByOrderId(UUID orderId);
}
