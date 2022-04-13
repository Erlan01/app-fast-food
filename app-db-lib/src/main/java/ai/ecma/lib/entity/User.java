package ai.ecma.lib.entity;

import ai.ecma.lib.entity.template.AbsUUID;
import ai.ecma.lib.enums.LanguageEnum;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Murtazayev Muhammad
 * @since 14.01.2022
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "set")
@Where(clause = "deleted=false")
@SQLDelete(sql = "update users set deleted = false where id = ?")
public class User extends AbsUUID {
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Builder.Default
    @Column(name = "password", nullable = false)
    private String password = "1234";

    @Column(name = "additional_phone_number")
    private String additionalPhoneNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telegram_id")
    private Long telegramId;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private LanguageEnum language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany
    private List<Address> defaultAddress;

    @OneToOne
    @JoinColumn(name = "photo_id")
    private Attachment photo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_permission",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions;//USERNING HUQUQLARI


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_branch")
    private Set<Branch> branches;

    @Column(name = "github_login")
    private String githubLogin;

    @Column(name = "confidence_rate")
    private double confidenceRate;

    @Column(name = "active")
    private boolean active = true;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lon")
    private Double lon;

    @Column(name = "online", nullable = false)
    private boolean online;

    @Builder.Default
    private boolean accountNonExpired = true;
    @Builder.Default
    private boolean accountNonLocked = true;
    @Builder.Default
    private boolean credentialsNonExpired = true;
    @Builder.Default
    private boolean enabled = false;

    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.phoneNumber;
    }

    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    public boolean isEnabled() {
        return this.enabled;
    }


    public User(String phoneNumber, String firstName, String lastName, District district, LanguageEnum language, Role role) {

        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.district = district;
        this.language = language;
        this.role = role;
    }

    public String getFullName(){
        return this.lastName + " " + this.firstName;
    }
}
