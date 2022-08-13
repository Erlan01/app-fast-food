package ai.ecma.lib.repository;

import ai.ecma.lib.entity.User;
import ai.ecma.lib.enums.RoleTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface not documented :(
 *
 * @author Muhammad Mo'minov
 * @since 17.01.2022
 */
public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByTelegramId(Long telegramId);

    Optional<User> findByIdAndRole_RoleTypeAndOnlineIsTrue(UUID id, RoleTypeEnum role_name);

    @Query(value = "select * from users u join roles r on u.role_id = r.id\n" +
            "where r.name = 'COURIER' order by calculate_distance(u.lat, u.lon, :branchLat, :branchLon) limit 1", nativeQuery = true)
    Optional<User> getNearlyCourier(@Param("branchLat") Double branchLat, @Param("branchLon") Double branchLon);

    Optional<User> findByPhoneNumber(String phoneNumber);

    Optional<User> findByEmail(String email);

    Optional<User> findByGithubLogin(String githubLogin);


    @Query(value = "select u.* from order_history oh\n" +
            "         join orders o on o.id = oh.order_id\n" +
            "         join users u on o.courier_id = u.id\n" +
            "where o.status = 'READY'\n" +
            "  and o.courier_id notnull\n" +
            "  and oh.status = 'READY'\n" +
            "  and oh.created_at < :pastTime", nativeQuery = true)
    List<User> getKuniBitganCouriers(@Param("pastTime") Timestamp timestamp);

}
