package ai.ecma.lib.repository;

import ai.ecma.lib.entity.DeliveryPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface DeliveryPromotionRepository extends JpaRepository<DeliveryPromotion, Long> {
    @Query(nativeQuery = true, value = "select dp.*\n" +
            "from delivery_promotion dp\n" +
            "         left join promotion p on p.id = dp.parent_id and :currentTime between p.start_time and p.end_time\n" +
            "where dp.deleted = false and p.deleted = false and dp.price <= :totalPrice")
    Optional<DeliveryPromotion> findActiveDeliveryPromotion(@Param(value = "currentTime") Timestamp currentTime,
                                                            @Param(value = "totalPrice") Double totalPrice);

    @Query(nativeQuery = true, value = "select dp.*\n" +
            "from delivery_promotion dp\n" +
            "         left join promotion p on p.id = dp.parent_id and :currentTime between p.start_time and p.end_time\n" +
            "where dp.deleted = false and p.deleted = false and dp.price <= :totalPrice and :deliveryHour between dp.start_time and dp.end_time")
    Optional<DeliveryPromotion> findActiveDeliveryPromotionWithDeliveryTime(@Param(value = "currentTime") Timestamp currentTime,
                                                                            @Param(value = "totalPrice") Double totalPrice,
                                                                            @Param(value = "deliveryHour") Time deliveryHour
    );


}
