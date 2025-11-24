package gpt.frist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam String firstname, Model model) {
        User user = userRepository.findByFirstname(firstname);
        if (user != null) {
            model.addAttribute("firstname", user.getFirstname());
            model.addAttribute("lastname", user.getLastname());
            model.addAttribute("message", "User found successfully!");
            return "welcome";
        }
        model.addAttribute("message", "User not found!");
        return "index";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute User user, Model model) {
        userRepository.save(user);
        model.addAttribute("firstname", user.getFirstname());
        model.addAttribute("lastname", user.getLastname());
        model.addAttribute("message", "User created successfully!");
        return "welcome";
    }

    @GetMapping("/user/update")
    public String showUpdateForm(@RequestParam(required = false) Long id, Model model) {
        if (id != null) {
            User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
            model.addAttribute("user", user);
        }
        return "index";
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestParam Long id, @ModelAttribute User user, Model model) {
        try {
            User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
            existingUser.setFirstname(user.getFirstname());
            existingUser.setLastname(user.getLastname());
            userRepository.save(existingUser);

            model.addAttribute("firstname", existingUser.getFirstname());
            model.addAttribute("lastname", existingUser.getLastname());
            model.addAttribute("message", "User updated successfully!");
            return "welcome";
        } catch (Exception e) {
            model.addAttribute("message", "Error updating user: " + e.getMessage());
            return "index";
        }
    }

    @PostMapping("/user/delete")
    public String deleteUser(@RequestParam Long id, Model model) {
        try {
            userRepository.deleteById(id);
            model.addAttribute("message", "User deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("message", "Error deleting user: " + e.getMessage());
        }
        return "index";
    }
}
