package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Order;
import ai.ecma.lib.entity.User;
import ai.ecma.lib.enums.OrderStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByCourierIdAndStatus(UUID courier_id, OrderStatusEnum status);

    Page<Order> findAllByStatusAndCourierIsNull(OrderStatusEnum status, Pageable pageable);

    Optional<Order> findByIdAndStatusAndCourierIsNull(UUID id, OrderStatusEnum status);

    Page<Order> findAllByOperatorIdAndStatus(UUID operator_id, OrderStatusEnum status, Pageable pageable);

    Page<Order> findAllByBranchIdAndStatus(Long branch_id, OrderStatusEnum status, Pageable pageable);

    boolean existsByCourierIdAndStatus(UUID courier_id, OrderStatusEnum status);

    Optional<Order> findByClientIdAndId(UUID clientId, UUID id);

    @Query("select o from orders o where o.client.id = ?1 and o.status = ?2")
    Optional<Order> findByClientBasket(UUID clientId, OrderStatusEnum status);

    Page<Order> findAllByClientIdAndStatus(UUID clientId, OrderStatusEnum status, Pageable pageable);

    List<Order> findAllByClientId(UUID clientId);

    boolean existsBySerialNumber(String serialNumber);

    long countByClientIdAndStatus(UUID client_id, OrderStatusEnum status);


    List<Order> findAllByCourierIdInAndStatus(Collection<UUID> courier_id, OrderStatusEnum status);

    @Transactional
    @Modifying
    @Query(value = "CREATE OR REPLACE FUNCTION calculate_distance(lat1 float, lon1 float, lat2 float, lon2 float)\n" +
            "    RETURNS double precision\n" +
            "    language plpgsql as $$\n" +
            "DECLARE\n" +
            "    dist float = 0;\n" +
            "    radlat1 float;\n" +
            "    radlat2 float;\n" +
            "    theta float;\n" +
            "    radtheta float;\n" +
            "BEGIN\n" +
            "    IF lat1 = lat2 OR lon1 = lon2\n" +
            "    THEN RETURN dist;\n" +
            "    ELSE\n" +
            "        radlat1 = pi() * lat1 / 180;\n" +
            "        radlat2 = pi() * lat2 / 180;\n" +
            "        theta = lon1 - lon2;\n" +
            "        radtheta = pi() * theta / 180;\n" +
            "        dist = sin(radlat1) * sin(radlat2) + cos(radlat1) * cos(radlat2) * cos(radtheta);\n" +
            "        IF dist > 1 THEN dist = 1; END IF;\n" +
            "        dist = acos(dist);\n" +
            "        dist = dist * 180 / pi();\n" +
            "        dist = dist * 60 * 1.1515;\n" +
            "        RETURN dist * 1.609344;\n" +
            "    END IF;\n" +
            "END $$;", nativeQuery = true)
    void createDistanceCalculatorFunc();
}
