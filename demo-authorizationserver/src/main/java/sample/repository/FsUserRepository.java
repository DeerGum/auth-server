package sample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sample.entity.FsUser;

public interface FsUserRepository extends JpaRepository<FsUser, Long> {
	Optional<FsUser> findByUserId(String userId);
}
