package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Promotion;
import ai.ecma.lib.entity.QuantityPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Repository
public interface QuantityPromotionRepository extends JpaRepository<QuantityPromotion, Long> {
    @Query(nativeQuery = true, value = "select qp.*\n" +
            "from quantity_promotion qp\n" +
            "         left join promotion p on p.id = qp.parent_id and :currentTime between p.start_time and p.end_time\n" +
            "where qp.deleted = false\n" +
            "  and p.deleted = false\n" +
            "  and qp.purchased_product_id in :productsId limit 1")
    Optional<QuantityPromotion> findActiveQuantityPromotions(@Param(value = "currentTime") Timestamp currentTime,
                                                             @Param(value = "productsId") Set<UUID> productsId);


}
