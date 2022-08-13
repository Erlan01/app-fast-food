package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Branch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    @Query("select b from branch b where b.address.district.region.id = ?1")
    Page<Branch> findAllByRegionId(Pageable pageable, Long regionId);

    @Query("select b from branch b where b.address.district.id = ?1")
    Page<Branch> findAllByDistrictId(Pageable pageable, Long districtId);

    Optional<Branch> findByIdAndActiveIsTrue(Long id);
}
