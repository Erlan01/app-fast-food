package ai.ecma.lib.repository;

import ai.ecma.lib.entity.OrderPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderPromotionRepository extends JpaRepository<OrderPromotion, UUID> {
}