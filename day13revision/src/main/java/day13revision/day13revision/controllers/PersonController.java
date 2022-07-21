package day13revision.day13revision.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import day13revision.day13revision.models.Person;
import day13revision.day13revision.services.PersonService;

@Controller
public class PersonController {

    // The controller will pull and store the data here for distribution later
    // therefore, 1st, create a container:
    private List<Person> personList = new ArrayList<>();

    // Controller will use the PersonService to extract the data from (an imaginary)
    // database:
    @Autowired
    private PersonService perSvc;

    @Value("${welcome.message}")
    private String welcomeMsg;

    @Value("${error.message}")
    private String errorMsg;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", welcomeMsg);
        return "index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Person> getAll() {
        personList = perSvc.getPersons();

        return personList;
    }

    @RequestMapping(value = "/displaylist", method = RequestMethod.GET, produces = "text/html")
    public String displayList(Model model) {
        personList = perSvc.getPersons();
        model.addAttribute("persons", personList);
        return "displaylist";
    }

    

}
