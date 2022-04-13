package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Recommended;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecommendedRepository extends JpaRepository<Recommended, UUID> {
}
