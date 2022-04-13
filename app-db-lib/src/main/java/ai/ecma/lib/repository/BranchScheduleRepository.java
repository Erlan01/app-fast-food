package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Branch;
import ai.ecma.lib.entity.BranchSchedule;
import ai.ecma.lib.enums.WeekdaysNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository
public interface BranchScheduleRepository extends JpaRepository<BranchSchedule, Long> {
    List<BranchSchedule> findAllByBranchId(Long branch_id);


    @Query(nativeQuery = true, value = "select count(bs.id) > 0\n" +
            "from branch_schedule bs\n" +
            "where branch_id = :branchId\n" +
            "  and week_name = :weekName\n" +
            "  and :orderTime between start_time and end_time")
    boolean existsAllByBranchIdAndWeekdaysNameEnumAndStar(@Param("branchId") Long branch,
                                                          @Param("weekName") String weekName,
                                                          @Param("orderTime") Time orderTime);
}
