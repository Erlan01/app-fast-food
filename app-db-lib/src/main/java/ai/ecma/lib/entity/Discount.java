package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "discount")
@SQLDelete(sql = "update discount set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Discount extends AbsLong {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "percent")
    private double percent;

    @Column(name = "expire_time", nullable = false)
    private Timestamp expireTime;

    @Column(name = "start_time", nullable = false)
    private Timestamp startTime;

    @Column(name = "price")
    private Double price;

    @Column(name = "active")
    private boolean active;
}
