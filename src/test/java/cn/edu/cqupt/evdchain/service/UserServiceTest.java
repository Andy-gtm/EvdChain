package cn.edu.cqupt.evdchain.service;

import cn.edu.cqupt.evdchain.entity.User;
import cn.edu.cqupt.evdchain.pojo.Message;
import cn.edu.cqupt.evdchain.pojo.UserInfo;
import cn.edu.cqupt.evdchain.servicel.UserServiceI;
import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserServiceI userService;

    @Test
    @Ignore
    public void register() {
        User user = new User();
        user.setPhone("18272160991");
        user.setPassword("19940512aa");
        user.setIdCard("420202199405120418");
        user.setEmail("254264284@qq.com");
        user.setFirstName("嘉成");
        user.setLastName("黄");
        user.setGender(1);
        String json = userService.register(user);
        Message message = new Gson().fromJson(json, Message.class);
        assertTrue(message.getStatus());
    }


    @Test
    public void list() {
        List<User> list = userService.list();
        assertTrue(list.size() > 0);
    }

    @Test
    @Transactional
    @Rollback
    public void ban() {
        User user = new User();
        user.setId("fdd1bb426f759d86016f759d92d40000");
        String json = userService.ban(user);
        Message message = new Gson().fromJson(json, Message.class);
        assertTrue(message.getStatus());
    }

    @Test
    @Transactional
    @Rollback
    public void delete() {
        User user = new User();
        user.setId("fdd1bb426f759d86016f759d92d40000");
        String json = userService.delete(user);
        Message message = new Gson().fromJson(json, Message.class);
        assertTrue(message.getStatus());
    }

    @Test
    public void loginWithPhone() {
        User user = new User();
        user.setPhone("18272160991");
        user.setPassword("19940512aa");
        UserInfo userInfo = userService.login(user);
        assertNotNull(userInfo.getId());
    }

    @Test
    public void loginWithIdCard() {
        User user = new User();
        user.setIdCard("420202199405120418");
        user.setPassword("19940512aa");
        UserInfo userInfo = userService.login(user);
        assertNotNull(userInfo.getId());
    }

    @Test
    public void loginWithEmail() {
        User user = new User();
        user.setEmail("254264284@qq.com");
        user.setPassword("19940512aa");
        UserInfo userInfo = userService.login(user);
        assertNotNull(userInfo.getId());
    }

}