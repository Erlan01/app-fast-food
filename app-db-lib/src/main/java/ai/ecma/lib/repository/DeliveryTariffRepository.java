package ai.ecma.lib.repository;

import ai.ecma.lib.entity.DeliveryPromotion;
import ai.ecma.lib.entity.DeliveryTariff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryTariffRepository extends JpaRepository<DeliveryTariff, Long> {
    List<DeliveryTariff> findAllByBranchId(Long branch_id);
    List<DeliveryTariff> findAllByBranchIdOrderByDistance(Long branch_id);
}
