package tiy.lecture.organizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

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
        if(tags.count() ==0) {
            Tag tag = new Tag("Heroku");
            Tag tagTwo = new Tag("SQL");
            Tag tagThree = new Tag("Spring");
            Tag tagFour = new Tag("Binary");
            Tag tagSix = new Tag("Batch");;
            Tag tagEight = new Tag("Class");
            Tag tagTen = new Tag("Control Structures");
            Tag tagFourteen = new Tag("Static Data Structures");
            Tag tagSeventeen = new Tag("File I/O");
            Tag tagEighteen = new Tag("Dynamic Data Structures");
            Tag tagTwenty = new Tag("JSON");
            Tag tagTwentyTwo = new Tag("Getters & Setters");
            Tag tagTwentyFour = new Tag("Interface");
            Tag tagTwentyFive = new Tag("UI");
            Tag tagTwentyEight = new Tag("Parse");
            Tag tagThirtyOne = new Tag("Networking");
            Tag tagThirtyFour = new Tag("Threads");
            Tag tagThirtyFive = new Tag("Unit Test");
            Tag tagThirtySix = new Tag("Git/GitHub");
            Tag tagForty = new Tag("Android Studio");
            Tag tagFortyOne = new Tag("Database");
            Tag tagFortyFive = new Tag("Deployment");
            tags.save(tagThree);
            tags.save(tagTwo);
            tags.save(tag);
            tags.save(tagFour);
            tags.save(tagSix);
            tags.save(tagEight);
            tags.save(tagTen);
            tags.save(tagFourteen);
            tags.save(tagSeventeen);
            tags.save(tagEighteen);
            tags.save(tagTwenty);
            tags.save(tagTwentyTwo);
            tags.save(tagTwentyFour);
            tags.save(tagTwentyFive);
            tags.save(tagTwentyEight);
            tags.save(tagThirtyOne);
            tags.save(tagThirtyFour);
            tags.save(tagThirtyFive);
            tags.save(tagThirtySix);
            tags.save(tagForty);
            tags.save(tagFortyOne);
            tags.save(tagFortyFive);

            if(languages.count()==0) {
                Language language = new Language("Java");
                Language languageTwo = new Language("Java Fx");
                Language languageThree = new Language("Javascript");
                Language languageFour = new Language("HTML");
                Language languageFive = new Language("CSS");
                Language languageSix = new Language("SQL");
                Language languageSeven = new Language("Phython");
                Language languageEight = new Language("AngularJS");
                Language languageNine = new Language("C#");
                Language languageTen = new Language("PHP");
                Language languageEleven = new Language("Ruby");
                Language languageTwelve = new Language("Swift");

                languages.save(language);
                languages.save(languageTwo);
                languages.save(languageThree);
                languages.save(languageFour);
                languages.save(languageFive);
                languages.save(languageSix);
                languages.save(languageSeven);
                languages.save(languageEight);
                languages.save(languageNine);
                languages.save(languageTen);
                languages.save(languageEleven);
                languages.save(languageTwelve);
            }
            if (users.count() == 0) {
                User user = new User();
                user.email = "Admin";
                user.password = "test123";
                user.cohort = "TIY";
                user.firstName = "Admin";
                user.lastName = "Admin";
                users.save(user);


                if (notes.count() == 0) {
                    Note noteOne = new Note();
                    noteOne.setNoteTitle("Command");

                    ArrayList<Tag> tagList = new ArrayList<Tag>();
                    Iterable<Tag> allTags = tags.findByTag("Class");
                    for (Tag tags : allTags) {
                        tagList.add(tags);
                    }
                    noteOne.setTags(tagList);

                    ArrayList<Language> languageList = new ArrayList<Language>();
                    Iterable<Language> allLanguages = languages.findByLanguage("Java");
                    for (Language languages : allLanguages) {
                        languageList.add(languages);
                    }
                    noteOne.setLanguages(languageList);

                    noteOne.setNoteCode("System.out.println(\"Hello World\")");
                    noteOne.setNoteText("System: class" + System.lineSeparator() + "out: object - instance of a class");
                    noteOne.setNoteLink("https://lecture-organizer.herokuapp.com");
                    noteOne.setUser(user);
                    notes.save(noteOne);
                }
            }
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
    public String addUser(Model model, HttpSession session, String fName, String lName, String userEmail, String school, String userPassword) {
        User user = new User(userEmail, userPassword, school, fName, lName);
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
