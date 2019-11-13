package apap.tutorial.shapee.controller;

import apap.tutorial.shapee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import apap.tutorial.shapee.model.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
        if (user.getPassword().length() < 8) {
            model.addAttribute("status", "Password tidak boleh kurang dari 8 karakter!");
            return "home";
        } else {
            if (user.getPassword().matches(".*[a-zA-Z].*") && user.getPassword().matches(".*[0-9].*")) {
                userService.addUser(user);
                model.addAttribute("status", "User baru berhasil ditambahkan");
                return "home";
            } else {
                model.addAttribute("status", "Password harus mengandung angka dan huruf");
                return "home";
            }
        }
    }

    @RequestMapping(value = "/updatePassword/{username}", method = RequestMethod.GET)
    private String updatePassword(@PathVariable(value = "username") String username, Model model){
        UserModel user = userService.getUserModel(username);
        model.addAttribute("user", user);
        model.addAttribute("username", username);
        model.addAttribute("statusUbahPass", "");
        return "form-update-password";
    }

    @RequestMapping(value = "/updatePassword/{username}", method = RequestMethod.POST)
    private String updatePasswordSubmit(@PathVariable(value = "username") String username, String oldPassword, String newPassword, String newPasswordConfirm, Model model) {
        UserModel user = userService.getUserModel(username);
            if (newPassword.matches(".*[a-zA-Z].*") && newPassword.matches(".*[0-9].*") && newPassword.length() >= 8) {
                if (newPassword.equals(newPasswordConfirm) == false) {
                    model.addAttribute("statusUbahPass", "Konfirmasi Password tidak sesuai!");
                    return "form-update-password";
                } else {
                    boolean valid = userService.validatePassword(user.getPassword(), oldPassword) == true;
                    if (valid == true) {
                        userService.updatePass(username, newPassword);
                        return "update-password-success";
                    } else {
                        model.addAttribute("statusUbahPass", "Password tidak sesuai!");
                        return "form-update-password";
                    }
                }
            }
            else{
                model.addAttribute("statusUbahPass", "Password harus mengandung huruf dan angka serta tidak boleh kurang dari 8 karakter!");
                return "form-update-password";
            }
        }
    }

