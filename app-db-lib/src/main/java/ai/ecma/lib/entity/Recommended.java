package ai.ecma.lib.entity;


import ai.ecma.lib.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "recommended")
@SQLDelete(sql = "update recommended set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Recommended extends AbsUUID {



    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "from_category_id")
    private Category fromCategory;          //  todo taklif qilingan ichimlik yo boshqa mahsulot

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "to_category_id")    // todo hotdogni tanlasa
    private Category toCategory;
}
