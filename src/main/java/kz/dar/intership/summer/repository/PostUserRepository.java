package kz.dar.intership.summer.repository;

import kz.dar.intership.summer.entity.PostUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostUserRepository extends JpaRepository<PostUser, Long> {
}
