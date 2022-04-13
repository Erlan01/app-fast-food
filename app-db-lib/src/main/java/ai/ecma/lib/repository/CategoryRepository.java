package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Branch;
import ai.ecma.lib.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);

    List<Category> findAllByParentIsNull();

    List<Category> findAllByParentId(Long parent_id);

    @Query(nativeQuery = true, value = "select c.id\n" +
            "from category c\n" +
            "         join category sc on sc.parent_id = c.id\n" +
            "where sc.id = 1\n" +
            "  and c.deleted = false;")
    Long findParentId(Long subcategoryId);
}
