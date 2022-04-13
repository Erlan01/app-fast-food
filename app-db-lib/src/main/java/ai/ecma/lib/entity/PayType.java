package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import ai.ecma.lib.enums.PayTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "pay_type")
@SQLDelete(sql = "update pay_type set deleted=true where id=?")
@Where(clause = "deleted=false")
public class PayType extends AbsLong implements Serializable {

    @Column(name = "name", nullable = false)
    @Enumerated(EnumType.STRING)
    private PayTypeEnum name;

    @Column(name = "active")
    private boolean active;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Attachment photo;
}
