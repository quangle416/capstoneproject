package org.perscholas.capstoneproject.contollers;

import org.perscholas.capstoneproject.dao.CustomerRepoI;
import org.perscholas.capstoneproject.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    CustomerRepoI customerRepoI;


    @GetMapping(value = {"/","index"})
    public String homePage(Model model){
        //using custom repo query to select by name
//    Customer customer = customerRepoI.findByfirstName("Quang").get();
        //using model object into repo to find by id
        model.addAttribute("cust1", customerRepoI.findById(3).get());
        return "index";
    }

@GetMapping("customerlogin")
public String customerLogin(){
        return "index";
}

    @PostMapping("registration")
    public String registrationForm (Model model) {
        model.addAttribute("customer", new Customer());
        return "cutomerlogin";
    }
}
