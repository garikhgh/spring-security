package am.hgh.springsecurity.repository;

import am.hgh.springsecurity.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntitiesByUserName(String userName);
}
