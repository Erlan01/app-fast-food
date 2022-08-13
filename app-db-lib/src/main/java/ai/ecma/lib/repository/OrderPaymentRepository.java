package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Order;
import ai.ecma.lib.entity.OrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderPaymentRepository extends JpaRepository<OrderPayment, UUID> {
    Optional<OrderPayment> findByOrderId(UUID orderId);
}
