package pl.mumanski.offertlyapi.postmanagement;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mumanski.offertlyapi.postmanagement.model.entity.Post;

interface PostRepository extends JpaRepository<Post, Long> {
}
