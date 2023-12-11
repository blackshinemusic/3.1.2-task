package kata_test_boot.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import kata_test_boot.springbootdemo.model.User;
import kata_test_boot.springbootdemo.service.UserService;

import javax.validation.Valid;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String usersALL(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String usersId(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "user";
    }


    @GetMapping("/add")
    public String addUser(User user) {
        return "create";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";

    }


    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.removeUser(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String updateUser(Model model, @PathVariable("id") long id) {
        model.addAttribute(userService.getUserId(id));
        return "change";
    }


    @PostMapping("/edit")
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "change";
        } else {
            userService.updateUser(user);
            return "redirect:/";
        }
    }
}