package ai.ecma.lib.repository;

import ai.ecma.lib.entity.OrderRate;
import ai.ecma.lib.entity.PayType;
import ai.ecma.lib.enums.PayTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PayTypeRepository extends JpaRepository<PayType, Long> {
    Optional<PayType> findByName(PayTypeEnum name);

    List<PayType> findAllByActiveTrue();

}
