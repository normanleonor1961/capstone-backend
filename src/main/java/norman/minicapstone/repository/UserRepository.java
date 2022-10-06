package norman.minicapstone.repository;

import norman.minicapstone.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.math.BigInteger;

interface UserRepository extends JpaRepository<UserEntity, BigInteger> {
    UserEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
