package com.sami.supershop.implementation;

import com.sami.supershop.domain.*;
import com.sami.supershop.dto.UserDto;
import com.sami.supershop.interfaces.UserService;
import com.sami.supershop.repository.*;
import com.sami.supershop.security.UserRoles;
import com.sami.supershop.utility.BasketEnum;
import com.sami.supershop.utility.DataStructureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final UserInformationRepository userInformationRepository;
    private final WalletRepository walletRepository;

    @Autowired
    public UserServiceImpl(RoleRepository roleRepository, BasketRepository basketRepository, UserRepository userRepository, UserInformationRepository userInformationRepository, WalletRepository walletRepository) {
        this.roleRepository = roleRepository;
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.userInformationRepository = userInformationRepository;
        this.walletRepository = walletRepository;
    }

    @Override
    public void addCustomer(UserDto userDto) {
        addUser(userDto, UserRoles.USER);
    }

    @Override
    public void addAdmin(UserDto userDto) {
        addUser(userDto, UserRoles.ADMIN);
    }

    @Override
    public void modifyUser(UserDto userDto) {

    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return DataStructureUtils.toList(userRepository.findAll());
    }

    private void addUser(UserDto userDto,UserRoles userRoles) {
        User user = new User();
        addUserMainInfo(userDto, user);
        addRole(userRoles, user);
        UserInformation userInformation = addUserExtendInformation(userDto.getUserInformation(), user);
        Wallet wallet = addWallet();
        Basket basket = addBasket(user, wallet);
        userRepository.save(user);
        userInformationRepository.save(userInformation);
        walletRepository.save(wallet);
        basketRepository.save(basket);

    }

    private void addUserMainInfo(UserDto userDto, User user) {
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
    }
    private UserInformation addUserExtendInformation(UserInformation userInformation, User user) {
        userInformation.setUser(user);
        return userInformation;
    }
    private void addRole(UserRoles userRoles, User user) {
       Role role = roleRepository.findByRoleValue(userRoles.getUser());
       user.setRole(role);
    }
    private Wallet addWallet() {
        Wallet wallet = new Wallet();
        wallet.setBalance(0F);
        return wallet;
    }
    private Basket addBasket(User user, Wallet wallet) {
        Basket basket = new Basket();
        basket.setUser(user);
        basket.setStatus(BasketEnum.EMPTY.getBasketStatus());
        basket.setWallet(wallet);
        return basket;
    }
}
