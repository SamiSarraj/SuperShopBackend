package com.sami.supershop.interfaces;

import com.sami.supershop.dto.UserDto;
import com.sami.supershop.domain.User;

import java.util.List;


public interface UserService {
    void addCustomer(UserDto userDto);
    void addAdmin(UserDto userDto);
    void modifyUser(UserDto userDto);
    void deleteUser(User user);
    User getUserByUsername(String userName);
    List<User> getAllUsers();
}
