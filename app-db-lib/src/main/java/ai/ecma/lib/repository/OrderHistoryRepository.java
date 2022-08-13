package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Order;
import ai.ecma.lib.entity.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends JpaRepository<OrderHistory, Long> {
}
