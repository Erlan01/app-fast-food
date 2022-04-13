package ai.ecma.lib.repository;

import ai.ecma.lib.entity.PromotionProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * This interface not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 01.02.2022
 */
public interface PromotionProductRepository extends JpaRepository<PromotionProduct, UUID> {
}
