package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.UserModel;
import apap.tutorial.shapee.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public UserModel getUserModel(String username) {
        return userDb.findByUsername(username);
    }

    @Override
    public Boolean validatePassword(String oldPassword, String oldPasswordInput) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(oldPasswordInput, oldPassword);
    }

    @Override
    public void updatePass(String username, String newPassword) {
        UserModel user = userDb.findByUsername(username);
        String newpassencrypt = encrypt(newPassword);
        user.setPassword(newpassencrypt);
        userDb.save(user);
    }

}
