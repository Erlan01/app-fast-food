package ai.ecma.lib.repository;

import ai.ecma.lib.entity.DeliveryTariff;
import ai.ecma.lib.entity.FeedBack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
}
