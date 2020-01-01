package cn.edu.cqupt.evdchain.servicel;

import cn.edu.cqupt.evdchain.entity.User;

public interface UserServiceI {

    /**
     * @param user The user need to be registered
     * @return Return a json string to indicate whether registration was successful,
     * and show the reasons if registration was failed
     */
    String register(User user);

}
