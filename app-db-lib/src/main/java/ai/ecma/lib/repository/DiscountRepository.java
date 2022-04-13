package ai.ecma.lib.repository;

import ai.ecma.lib.entity.DeliveryTariff;
import ai.ecma.lib.entity.Discount;
import ai.ecma.lib.entity.District;
import ai.ecma.lib.payload.ApiResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long> {
    boolean existsByName(String name);
}
