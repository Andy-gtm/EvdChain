package cn.edu.cqupt.evdchain.service;

import cn.edu.cqupt.evdchain.entity.User;
import cn.edu.cqupt.evdchain.pojo.Message;
import cn.edu.cqupt.evdchain.pojo.UserInfo;
import cn.edu.cqupt.evdchain.repository.UserRepository;
import cn.edu.cqupt.evdchain.servicel.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceI {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public String register(User user) {
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);
        user.setGmtCreated(new Timestamp(System.currentTimeMillis()));
        user.setGmtModified(new Timestamp(System.currentTimeMillis()));
        user = userRepository.save(user);

        if (user.getId() == null) return new Message(false, "registration is failed").toString();

        return new Message(true, "registration is successful").toString();
    }

    @Override
    public String ban(User user) {
        Optional<User> optional = userRepository.findById(user.getId());
        if (!optional.isPresent()) return new Message(false, "the user is not existed").toString();
        user = optional.get();
        user.setStatus(0);
        user.setGmtModified(new Timestamp(System.currentTimeMillis()));
        userRepository.save(user);
        return new Message(true, "banning is successful").toString();
    }

    @Override
    public String delete(User user) {
        userRepository.deleteById(user.getId());
        return new Message(true, "deletion is successful").toString();
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public UserInfo login(User user) {
        Optional<User> optional;
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);

        if (user.getIdCard() != null) {
            optional = userRepository.findByIdCardAndPassword(user.getIdCard(), user.getPassword());
        } else if (user.getPhone() != null) {
            optional = userRepository.findByPhoneAndPassword(user.getPhone(), user.getPassword());
        } else {
            optional = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        }

        UserInfo userInfo = new UserInfo();

        if (!optional.isPresent()) return userInfo;

        user = optional.get();
        userInfo.setId(user.getId());
        userInfo.setEmail(user.getEmail());
        userInfo.setIdCard(user.getIdCard());
        userInfo.setPhone(user.getPhone());
        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setGender(user.getGender());
        userInfo.setGmtModified(user.getGmtModified());
        userInfo.setGmtCreated(user.getGmtCreated());
        return userInfo;
    }


}
