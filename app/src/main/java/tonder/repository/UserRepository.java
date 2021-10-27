package tonder.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tonder.entity.User;
import tonder.entity.projection.UserIdProjection;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @EntityGraph("User.roles")
    Optional<User>      findOneWithRolesByUsername(String username);

    UserIdProjection    findOneByUsername(String username);
}
