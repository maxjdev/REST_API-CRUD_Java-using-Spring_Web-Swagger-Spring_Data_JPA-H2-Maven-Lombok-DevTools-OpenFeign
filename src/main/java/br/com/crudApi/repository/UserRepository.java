package br.com.crudApi.repository;

import br.com.crudApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author maxjdev
 */

public interface UserRepository extends JpaRepository<User, Long> {
}
