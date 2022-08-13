package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import ai.ecma.lib.enums.FeedBackTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "support")
@SQLDelete(sql = "update support set deleted=true where id=?")
@Where(clause = "deleted=false")
public class FeedBack extends AbsLong {

    //todo FAZLIDDIN aka CRUD qilishingiz kk ekan!!! 26.01

    @Column(name = "title", nullable = false)
    private String title;


    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private FeedBackTypeEnum type;


    @Column(name = "text", nullable = false)
    private String text;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
