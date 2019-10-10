package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.uniqueEntities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    @Override
    void delete(Category category);
}
