package ru.innopolis.stc12.conrtollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.stc12.pojo.User;
import ru.innopolis.stc12.security.Actions;
import ru.innopolis.stc12.service.UserService;

@Controller
public class UsersListController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Secured(Actions.USER_LIST_VIEW)
    @RequestMapping(value = "/userslist", method = RequestMethod.GET)
    public String showUsersListPage(Model model) {
        model.addAttribute("users", userService.getUsersList());
        return "userslist";

    }

    @RequestMapping(value = "/avaibleuser/{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        user.setEnabled(!user.isEnabled());
        userService.updateUser(user);
        return showUsersListPage(model);
    }

    @RequestMapping(value = "/removeuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id, Model model) {
        userService.deleteUserById(id);
        return showUsersListPage(model);
    }

}
