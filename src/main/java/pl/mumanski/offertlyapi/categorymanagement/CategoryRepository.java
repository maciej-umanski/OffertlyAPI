package pl.mumanski.offertlyapi.categorymanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mumanski.offertlyapi.categorymanagement.model.entity.Category;

interface CategoryRepository extends JpaRepository<Category, Long> {
}
