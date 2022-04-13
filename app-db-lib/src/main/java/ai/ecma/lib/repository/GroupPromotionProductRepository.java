package ai.ecma.lib.repository;

import ai.ecma.lib.entity.GroupPromotion;
import ai.ecma.lib.entity.GroupPromotionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface GroupPromotionProductRepository extends JpaRepository<GroupPromotionProduct, Long> {
    @Query(nativeQuery = true, value = "select gpp.*\n" +
            "from group_promotion_product gpp\n" +
            "         left join group_promotion gp on gp.id = gpp.group_promotion_id\n" +
            "         left join promotion p on p.id = gp.parent_id and :currentTime between p.start_time and p.end_time\n" +
            "where gp.deleted = false\n" +
            "  and p.deleted = false\n" +
            "  and gpp.deleted = false\n" +
            "  and gp.price <= :totalPrice")
    List<GroupPromotionProduct> findPromotionProducts(@Param(value = "currentTime") Timestamp currentTime,
                                                      @Param(value = "totalPrice") Double totalPrice);
}
