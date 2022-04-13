package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Promotion;
import ai.ecma.lib.entity.SimplePromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface SimplePromotionRepository extends JpaRepository<SimplePromotion, Long> {
    @Query(nativeQuery = true, value = "select sp.*\n" +
            "from simple_promotion sp\n" +
            "         left join promotion p on p.id = sp.parent_id and :currentTime between p.start_time and p.end_time\n" +
            "where sp.deleted = false and p.deleted = false and sp.price <= :totalPrice")
    Optional<SimplePromotion> findActiveSimplePromotion(@Param(value = "currentTime") Timestamp currentTime,
                                                        @Param(value = "totalPrice") Double totalPrice);
}
