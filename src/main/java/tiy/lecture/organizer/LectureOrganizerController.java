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

    @Autowired
    TagRepository tags;

    @Autowired
    LanguageRepository languages;

    @PostConstruct
    public void init() {
        if (users.count() == 0) {
            User user = new User();
            user.email = "Admin";
            user.password = "test123";
            user.dateOfBirth = "01/01/0001";
            user.cohort = "TIY";
            user.firstName = "Admin";
            user.lastName = "Admin";
            users.save(user);

        }
    }

    @PostConstruct
    public void addTopicsDef()  {
        if(tags.count() ==0) {
            Tag tag = new Tag();
            tag.name = "Heroku";
            Tag tagTwo = new Tag();
            tagTwo.name = "SQL";
            Tag tagThree = new Tag();
            tagThree.name = "Spring";
            tags.save(tagThree);
            tags.save(tagTwo);
            tags.save(tag);
        }
    }

    @PostConstruct
    public void addLanguages() {
        if(languages.count()==0) {
            Language language = new Language("Java");
            Language languageTwo = new Language("Java Fx");
            Language languageThree = new Language("PHP");
            Language languageFour = new Language("CSS");
            Language languageFive = new Language("Phython");
            Language languageSix = new Language("SQL");
            Language languageSeven = new Language("Html");
            languages.save(language);
            languages.save(languageTwo);
            languages.save(languageThree);
            languages.save(languageFour);
            languages.save(languageFive);
            languages.save(languageSix);
            languages.save(languageSeven);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {

        if (session.getAttribute("user") != null) {
            model.addAttribute("user", session.getAttribute("user"));
        }

        String errorMessage = (String)session.getAttribute("error");
        if (errorMessage != null) {
            model.addAttribute("error", errorMessage);
        }

        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session, String email, String password) {
        User user = users.findByEmail(email);
        System.out.println("<============================>");
        System.out.println("User email: " + user.email.toString());
        System.out.println("User password: " + user.password.toString());
        if (user == null || !password.equals(user.getPassword())) {
            String errorMessage = "Login error - please check your credentials and try again";
            session.setAttribute("error", errorMessage);
            return "redirect:/";
        }
            session.setAttribute("user", user);
            model.addAttribute(user);

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
    public String userLogin(Model model, HttpSession session,User user) {
        user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute(user);
        }
        return "notes";
    }

    @RequestMapping(path = "/usersignup", method = RequestMethod.GET)
    public String userSignup(Model model, HttpSession session) {

        return "adduser";
    }

    @RequestMapping(path = "/adduser", method = RequestMethod.POST)
    public String addUser(Model model, HttpSession session, String fName, String lName, String userEmail, String DBA, String school, String userPassword) {
        User user = new User(userEmail, userPassword, DBA, school, fName, lName);
        System.out.println("<===============================================================>");
        System.out.println("New users first name: " + user.firstName.toString());
        System.out.println("New users last name: " + user.lastName.toString());
        System.out.println("New user email: " + user.email);
        System.out.println("New user school/cohort: " + user.cohort.toString());
        System.out.println("<===============================================================>");
        users.save(user);
        session.setAttribute("user", user);
        model.addAttribute(user);
        return "redirect:/notes";
    }
}
