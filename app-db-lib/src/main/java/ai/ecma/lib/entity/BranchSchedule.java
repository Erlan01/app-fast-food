package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import ai.ecma.lib.enums.WeekdaysNameEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "branch_schedule")
@SQLDelete(sql = "update branch_schedule set deleted=true where id=?")
@Where(clause = "deleted=false")
public class BranchSchedule extends AbsLong {

    @Column(name = "week_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private WeekdaysNameEnum weekdaysNameEnum;

    @Column(name = "start_time", nullable = false)
    private Time startTime;

    @Column(name = "end_time", nullable = false)
    private Time endTime;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;
}
