package ai.ecma.lib.repository;

import ai.ecma.lib.entity.GroupPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupPromotionRepository extends JpaRepository<GroupPromotion, Long> {
}
