package tonder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tonder.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
