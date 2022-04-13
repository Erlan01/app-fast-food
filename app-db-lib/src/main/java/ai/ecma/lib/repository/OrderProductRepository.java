package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Order;
import ai.ecma.lib.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, UUID> {
    Optional<OrderProduct> findByOrderIdAndProductId(UUID orderId, UUID productId);

    List<OrderProduct> findByOrderId(UUID orderId);

    @Query(nativeQuery = true, value = "select op.* from order_product op\n" +
            "join orders o on o.id = op.order_id and o.status = 'BASKET' and o.deleted = false\n" +
            "join users u on o.client_id = u.id and u.deleted = false\n" +
            "where u.telegram_id =:telegramId  and op.deleted = false")
    List<OrderProduct> findByTelegramId(Long telegramId);
}
