package ai.ecma.lib.repository;

import ai.ecma.lib.entity.Branch;
import ai.ecma.lib.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
}
