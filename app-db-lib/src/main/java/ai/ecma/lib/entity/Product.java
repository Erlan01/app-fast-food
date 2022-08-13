package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@SQLDelete(sql = "update product set deleted=true where id=?")
@Where(clause = "deleted=false")
public class Product extends AbsUUID {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToOne
    @JoinColumn(nullable = false, name = "photo_id")
    private Attachment photo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    private Discount discount;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private boolean active;
}
