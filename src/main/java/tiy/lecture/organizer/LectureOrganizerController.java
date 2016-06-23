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
                Language languageTwo = new Language("JavaFX");
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

                    ArrayList<Tag> noteOneTagList = new ArrayList<Tag>();
                    Iterable<Tag> noteOneTags = tags.findByTag("Class");
                    for (Tag tags : noteOneTags) {
                        noteOneTagList.add(tags);
                    }
                    noteOne.setTags(noteOneTagList);

                    ArrayList<Language> noteOneLanguageList = new ArrayList<Language>();
                    Iterable<Language> noteOneLanguages = languages.findByLanguage("Java");
                    for (Language languages : noteOneLanguages) {
                        noteOneLanguageList.add(languages);
                    }
                    noteOne.setLanguages(noteOneLanguageList);

                    noteOne.setNoteCode("System.out.println(\"Hello World\")");
                    noteOne.setNoteText("System: class; out: object - instance of a class");
                    noteOne.setNoteLink("https://online.theironyard.com/paths/185/units/960/lessons/2861");
                    noteOne.setUser(user);
                    notes.save(noteOne);


                        Note noteTwo = new Note();
                        noteTwo.setNoteTitle("ArrayList");

                        ArrayList<Tag> noteTwoTagList = new ArrayList<Tag>();
                        Iterable<Tag> noteTwoTags = tags.findByTag("Dynamic Data Structures");
                        for (Tag tags : noteTwoTags) {
                            noteTwoTagList.add(tags);
                        }
                        noteTwo.setTags(noteTwoTagList);

                        ArrayList<Language> noteTwoLanguageList = new ArrayList<Language>();
                        Iterable<Language> noteTwoLanguages = languages.findByLanguage("Java");
                        for (Language languages : noteTwoLanguages) {
                            noteTwoLanguageList.add(languages);
                        }
                        noteTwo.setLanguages(noteTwoLanguageList);

                        noteTwo.setNoteCode("ArrayList<Language> noteTwoLanguageList = new ArrayList<Language>();");
                        noteTwo.setNoteText("Resizable-array implementation of the List interface");
                        noteTwo.setNoteLink("https://online.theironyard.com/paths/185/units/1133/lessons/4040");
                        noteTwo.setUser(user);
                        notes.save(noteTwo);

                    Note noteThree = new Note();
                    noteThree.setNoteTitle("SQL");

                    ArrayList<Tag> noteThreeTagList = new ArrayList<Tag>();
                    Iterable<Tag> noteThreeTags = tags.findByTag("Database");
                    for (Tag tags : noteThreeTags) {
                        noteThreeTagList.add(tags);
                    }
                    noteThree.setTags(noteTwoTagList);

                    ArrayList<Language> noteThreeLanguageList = new ArrayList<Language>();
                    Iterable<Language> noteThreeLanguages = languages.findByLanguage("Java");
                    for (Language languages : noteThreeLanguages) {
                        noteThreeLanguageList.add(languages);
                    }
                    noteThree.setLanguages(noteThreeLanguageList);

                    noteThree.setNoteCode("@Query(\"SELECT g FROM Note g WHERE g.noteTitle LIKE ?1%\")\n" +
                            "    List<Note>findByNameStartsWith(String noteTitle);");
                    noteThree.setNoteText("Relational Database: organize data into tables with rows & columns");
                    noteThree.setNoteLink("https://online.theironyard.com/paths/185/units/1493/lessons/5563");
                    noteThree.setUser(user);
                    notes.save(noteThree);

                        Note noteFour = new Note();
                        noteFour.setNoteTitle("Canvas");

                        ArrayList<Tag> noteFourTagList = new ArrayList<Tag>();
                        Iterable<Tag> noteFourTags = tags.findByTag("Spring");
                        for (Tag tags : noteFourTags) {
                            noteFourTagList.add(tags);
                        }
                        noteFour.setTags(noteFourTagList);

                        ArrayList<Language> noteFourLanguageList = new ArrayList<Language>();
                        Iterable<Language> noteFourLanguages = languages.findByLanguage("Java");
                        for (Language languages : noteFourLanguages) {
                            noteFourLanguageList.add(languages);
                        }
                        Iterable<Language> noteFourLanguagesTwo = languages.findByLanguage("JavaFX");
                        for (Language languages : noteFourLanguagesTwo) {
                            noteFourLanguageList.add(languages);
                        }
                        noteFour.setLanguages(noteFourLanguageList);

                        noteFour.setNoteCode("@Override\n" +
                                "    public void start(Stage primaryStage) throws Exception {}");
                        noteFour.setNoteText("The JavaFX Canvas API provides a custom texture that you can write to.");
                        noteFour.setNoteLink("https://online.theironyard.com/paths/185/units/1248/lessons/4341");
                        noteFour.setUser(user);
                        notes.save(noteFour);
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
