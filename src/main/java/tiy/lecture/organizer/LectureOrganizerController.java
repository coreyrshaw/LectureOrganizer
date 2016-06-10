package tiy.lecture.organizer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Godfather on 6/10/2016.
 */
@Controller
public class LectureOrganizerController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {

        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(Model model, HttpSession session) {

        return "notes";
    }

    @RequestMapping(path = "/addnote", method = RequestMethod.GET)
    public String addnote(Model model, HttpSession session) {

        return "addnote";
    }

    @RequestMapping(path = "/notes", method = RequestMethod.GET)
    public String userLogin(Model model, HttpSession session, String login, String password) {

        return "notes";
    }


}
