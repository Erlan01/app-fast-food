package ai.ecma.lib.repository;

import ai.ecma.lib.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findAllByRegionId(Long region_id);
}