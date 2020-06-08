package page.danya.tanderDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import page.danya.tanderDemo.Models.Comment;
import page.danya.tanderDemo.Models.Region;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

//    List<Comment> findByRegion(Region region);
}
