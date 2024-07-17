package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userList(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "start_users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/add")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam(name = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}