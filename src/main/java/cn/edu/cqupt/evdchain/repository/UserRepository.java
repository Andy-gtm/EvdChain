package cn.edu.cqupt.evdchain.repository;


import cn.edu.cqupt.evdchain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
