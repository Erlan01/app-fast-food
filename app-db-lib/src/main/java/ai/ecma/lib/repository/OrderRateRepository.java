package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Order;
import ai.ecma.lib.entity.OrderRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRateRepository extends JpaRepository<OrderRate, UUID> {
    List<OrderRate> findAllByOrderId(UUID orderId);
}
