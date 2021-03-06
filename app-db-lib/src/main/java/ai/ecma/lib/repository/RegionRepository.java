package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findByName(String name);

    List<Region> findAllByOrderByName();
}