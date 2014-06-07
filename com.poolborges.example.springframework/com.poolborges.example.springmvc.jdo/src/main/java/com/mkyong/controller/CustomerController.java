package com.mkyong.controller;

import com.mkyong.PMF;
import com.mkyong.model.Customer;
import java.util.Date;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddCustomerPage(ModelMap model) {

        return "add";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(HttpServletRequest request, ModelMap model) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setDate(new Date());

        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(c);
        } finally {
            pm.close();
        }

        return new ModelAndView("redirect:list");

    }

    @RequestMapping(value = "/update/{name}", method = RequestMethod.GET)
    public String getUpdateCustomerPage(@PathVariable String name,
            HttpServletRequest request, ModelMap model) {

        PersistenceManager pm = PMF.get().getPersistenceManager();

        Query q = pm.newQuery(Customer.class);
        q.setFilter("name == nameParameter");
        q.setOrdering("date desc");
        q.declareParameters("String nameParameter");

        try {
            List<Customer> results = (List<Customer>) q.execute(name);

            if (results.isEmpty()) {
                model.addAttribute("customer", null);
            } else {
                model.addAttribute("customer", results.get(0));
            }
        } finally {
            q.closeAll();
            pm.close();
        }

        return "update";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(HttpServletRequest request, ModelMap model) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String key = request.getParameter("key");

        PersistenceManager pm = PMF.get().getPersistenceManager();

        try {

            Customer c = pm.getObjectById(Customer.class, key);

            c.setName(name);
            c.setEmail(email);
            c.setDate(new Date());

        } finally {

            pm.close();
        }

        // return to list
        return new ModelAndView("redirect:list");

    }

    @RequestMapping(value = "/delete/{key}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable String key,
            HttpServletRequest request, ModelMap model) {

        PersistenceManager pm = PMF.get().getPersistenceManager();

        try {

            Customer c = pm.getObjectById(Customer.class, key);
            pm.deletePersistent(c);

        } finally {
            pm.close();
        }

        // return to list
        return new ModelAndView("redirect:../list");

    }

    // get all customers
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listCustomer(ModelMap model) {

        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query q = pm.newQuery(Customer.class);
        q.setOrdering("date desc");

        List<Customer> results = null;

        try {
            results = (List<Customer>) q.execute();

            if (results.isEmpty()) {
                model.addAttribute("customerList", null);
            } else {
                model.addAttribute("customerList", results);
            }

        } finally {
            q.closeAll();
            pm.close();
        }

        return "list";

    }
}