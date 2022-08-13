package ai.ecma.lib.repository;

import ai.ecma.lib.entity.OrderRate;
import ai.ecma.lib.entity.PayType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayTypeRepository extends JpaRepository<PayType, Long> {

}
