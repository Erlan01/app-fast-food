package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsLong;
import ai.ecma.lib.enums.NotificationType;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "notification")
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Where(clause = "deleted=false")
@SQLDelete(sql = "update notification set deleted = false where id = ?")
public class Notification extends AbsLong {

    //todo FAZLIDDIN aka CRUD qilishingiz kk ekan!!! 26.01

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @Column(name = "text", columnDefinition = "text")
    private String text;

    @Column(name = "notification_type")
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

}