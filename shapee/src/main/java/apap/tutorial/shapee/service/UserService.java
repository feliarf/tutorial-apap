package apap.tutorial.shapee.service;

import apap.tutorial.shapee.model.UserModel;


public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel getUserModel(String username);
    void updatePass(String username, String newPassword);
    Boolean validatePassword(String oldPassword, String oldPasswordInput);

}
