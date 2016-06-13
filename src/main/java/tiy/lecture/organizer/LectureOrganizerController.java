package tiy.lecture.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

/**
 * Created by Godfather on 6/10/2016.
 */
@Controller
public class LectureOrganizerController {

    @Autowired
    NoteRepository notes;

    @Autowired
    UserRepository users;

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.email = "Admin";
            user.password = "test123";
            users.save(user);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {

        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, String userEmail, String userPassword) throws Exception {

        User user = users.findByEmail(userEmail);

        if (!userPassword.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        }
//        if (!userEmail.equals(user.getEmail())) {
//            throw new Exception("Incorrect email");

            session.setAttribute("user", user);

        return "redirect:/notes";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/addnote", method = RequestMethod.GET)
    public String addnote(Model model, HttpSession session) {

        return "addnote";
    }

    @RequestMapping(path = "/notes", method = RequestMethod.GET)
    public String userLogin(Model model, HttpSession session) {

        return "notes";
    }

    @RequestMapping(path = "/usersignup", method = RequestMethod.GET)
    public String userSignup(Model model, HttpSession session) {

        return "adduser";
    }

    @RequestMapping(path = "/adduser", method = RequestMethod.POST)
    public String addUser(Model model, HttpSession session, String fName, String lName, String userEmail, String DBA, String school, String userPassword) {

        User user = new User(userEmail, userPassword, DBA, school, fName, lName);
        users.save(user);
        session.setAttribute("user", user);
        return "redirect:/notes";
    }

//    ArrayList<User> getAllUsers() {
//        ArrayList<User> userList = new ArrayList<User>();
//        Iterable<User> allUsers = users.findAll();
//        for (User user : allUsers) {
//            userList.add(user);
//        }
//
//        return userList;
//    }

}
