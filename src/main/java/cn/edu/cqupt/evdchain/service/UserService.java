package cn.edu.cqupt.evdchain.service;

import cn.edu.cqupt.evdchain.entity.User;
import cn.edu.cqupt.evdchain.pojo.Message;
import cn.edu.cqupt.evdchain.repository.UserRepository;
import cn.edu.cqupt.evdchain.servicel.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;

@Service
public class UserService implements UserServiceI {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String register(User user) {
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        user.setGmtCreate(new Timestamp(System.currentTimeMillis()));
        user.setGmtModified(new Timestamp(System.currentTimeMillis()));
        user = userRepository.save(user);
        System.out.println(user.getId());
        if (user.getId() != null) {
            return new Message(true, "registration is successful").toString();
        }

        return new Message(false, "registration is failed").toString();
    }
}
