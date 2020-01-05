package cn.edu.cqupt.evdchain.servicel;

import cn.edu.cqupt.evdchain.entity.User;
import cn.edu.cqupt.evdchain.pojo.UserInfo;

import java.util.List;

public interface UserServiceI {

    /**
     * register an user
     *
     * @param user The {@link User} object of the user need to be registered
     * @return Return a json string to indicate whether the registration was successful,
     * and show the reasons if registration was failed
     * @see User
     */
    String register(User user);

    /**
     * ban an user
     *
     * @param user The {@link User} object containing the id of the user need to be banned
     * @return Return a json string to indicate whether the banning was successful,
     * and show the reasons if banning was failed
     * @see User
     */
    String ban(User user);

    /**
     * delete an user
     *
     * @param user The {@link User} object containing the id of the user need to be deleted
     * @return Return a json string to indicate whether the deletion was successful,
     * and show the reasons if deletion was failed
     * @see User
     */
    String delete(User user);


    /**
     * list user
     *
     * @return Return a {@link List} containing all users in databases
     * @see User
     */
    List<User> list();

    /**
     * login with ID Card/phone number/email + password
     *
     * @param user The {@link User} object containing the idCard/phone/email and password of the user need to login
     * @return Return an {@link UserInfo} object containing the information of user if login successful
     */
    UserInfo login(User user);

}
