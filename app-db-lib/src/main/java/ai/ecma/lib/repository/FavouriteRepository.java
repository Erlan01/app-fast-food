package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, UUID> {
    boolean existsFavouriteById(UUID id);
    Optional<Favourite> findByIdAndUserId(UUID id, UUID user_id);
    List<Favourite> findAllByUserId(UUID user_id);

    @Transactional
    @Modifying
    void deleteAllByUserId(UUID user_id);
}
