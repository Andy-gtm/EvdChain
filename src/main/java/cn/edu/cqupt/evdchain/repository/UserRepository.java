package cn.edu.cqupt.evdchain.repository;


import cn.edu.cqupt.evdchain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByIdCardAndPassword(String idCard, String password);

    Optional<User> findByPhoneAndPassword(String phone, String password);

    Optional<User> findByEmailAndPassword(String email, String password);


}
