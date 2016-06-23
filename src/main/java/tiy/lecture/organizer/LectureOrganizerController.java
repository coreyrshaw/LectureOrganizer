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
            Tag tag = new Tag();
            tag.name = "Heroku";
            Tag tagTwo = new Tag();
            tagTwo.name = "SQL";
            Tag tagThree = new Tag();
            tagThree.name = "Spring";
            Tag tagFour = new Tag("Binary");
            Tag tagFive = new Tag("Method");
            Tag tagSix = new Tag("Batch");
            Tag tagSeven = new Tag("Variable");
            Tag tagEight = new Tag("Class");
            Tag tagNine = new Tag("Boolean");
            Tag tagTen = new Tag("Control Structures");
            Tag tagEleven = new Tag("Modifiers");
            Tag tagTwelve = new Tag("Exceptions");
            Tag tagThirteen = new Tag("Parameters");
            Tag tagFourteen = new Tag("Arrays");
            Tag tagFifteen = new Tag("Object");
            Tag tagSixteen = new Tag("Fields");
            Tag tagSeventeen = new Tag("File I/O");
            Tag tagEighteen = new Tag("Dynamic Data Structures");
            Tag tagNineteen = new Tag("HashMap");
            Tag tagTwenty = new Tag("JSON");
            Tag tagTwentyOne = new Tag("Scope");
            Tag tagTwentyTwo = new Tag("Getters");
            Tag tagTwentyThree = new Tag("Setters");
            Tag tagTwentyFour = new Tag("Interface");
            Tag tagTwentyFive = new Tag("UI");
            Tag tagTwentySix = new Tag("Date");
            Tag tagTwentySeven = new Tag("Time");
            Tag tagTwentyEight = new Tag("Parse");
            Tag tagTwentyNine = new Tag("Format");
            Tag tagThirty = new Tag("API");
            Tag tagThirtyOne = new Tag("Networking");
            Tag tagThirtyTwo = new Tag("Socket");
            Tag tagThirtyThree = new Tag("Server");
            Tag tagThirtyFour = new Tag("Threads");
            Tag tagThirtyFive = new Tag("Unit Test");
            Tag tagThirtySix = new Tag("Git");
            Tag tagThirtySeven = new Tag("GitHub");
            Tag tagThirtyEight = new Tag("Attributes");
            Tag tagThirtyNine = new Tag("Mustache");
            Tag tagForty = new Tag("Android Studio");
            Tag tagFortyOne = new Tag("Database");
            Tag tagFortyTwo = new Tag("Joins");
            Tag tagFortyThree = new Tag("PostgreSQL");
            Tag tagFortyFour = new Tag("Query");
            Tag tagFortyFive = new Tag("Deployment");
            tags.save(tagThree);
            tags.save(tagTwo);
            tags.save(tag);
            tags.save(tagFour);
            tags.save(tagFive);
            tags.save(tagSix);
            tags.save(tagSeven);
            tags.save(tagEight);
            tags.save(tagNine);
            tags.save(tagTen);
            tags.save(tagEleven);
            tags.save(tagTwelve);
            tags.save(tagThirteen);
            tags.save(tagFourteen);
            tags.save(tagFifteen);
            tags.save(tagSixteen);
            tags.save(tagSeventeen);
            tags.save(tagEighteen);
            tags.save(tagNineteen);
            tags.save(tagTwenty);
            tags.save(tagTwentyOne);
            tags.save(tagTwentyTwo);
            tags.save(tagTwentyThree);
            tags.save(tagTwentyFour);
            tags.save(tagTwentyFive);
            tags.save(tagTwentySix);
            tags.save(tagTwentySeven);
            tags.save(tagTwentyEight);
            tags.save(tagTwentyNine);
            tags.save(tagThirty);
            tags.save(tagThirtyOne);
            tags.save(tagThirtyTwo);
            tags.save(tagThirtyThree);
            tags.save(tagThirtyFour);
            tags.save(tagThirtyFive);
            tags.save(tagThirtySix);
            tags.save(tagThirtySeven);
            tags.save(tagThirtyEight);
            tags.save(tagThirtyNine);
            tags.save(tagForty);
            tags.save(tagFortyOne);
            tags.save(tagFortyTwo);
            tags.save(tagFortyThree);
            tags.save(tagFortyFour);
            tags.save(tagFortyFive);

            if(languages.count()==0) {
                Language language = new Language("Java");
                Language languageTwo = new Language("Java Fx");
                Language languageThree = new Language("PHP");
                Language languageFour = new Language("CSS");
                Language languageFive = new Language("Phython");
                Language languageSix = new Language("SQL");
                Language languageSeven = new Language("Html");
                Language languageEight = new Language("AngularJS");
                Language languageNine = new Language("C#");
                Language languageTen = new Language("Javascript");
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
                    noteOne.setNoteTitle("Note One Test");

                    ArrayList<Tag> tagList = new ArrayList<Tag>();
                    Iterable<Tag> allTags = tags.findAll();
                    for (Tag tags : allTags) {
                        tagList.add(tags);
                    }
                    noteOne.setTags(tagList);

                    ArrayList<Language> languageList = new ArrayList<Language>();
                    Iterable<Language> allLanguages = languages.findAll();
                    for (Language languages : allLanguages) {
                        languageList.add(languages);
                    }
                    noteOne.setLanguages(languageList);

                    noteOne.setNoteCode("System.out.println(\"Hello World\")");
                    noteOne.setNoteText("Test Comment");
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
