package com.project.iacontent.controller;

import com.project.iacontent.dao.HibernateDao;
import com.project.iacontent.model.Admin;
import com.project.iacontent.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    HibernateDao hibernateDao;

    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Login");
        return modelAndView;
    }

    @PostMapping("/loginAdmin")
    public ModelAndView login(HttpSession session, @ModelAttribute Admin admin) {
        List<Admin> list = hibernateDao.findWhere(admin);
        ModelAndView modelAndView = new ModelAndView();

        if(list.size() == 0) {
            modelAndView.setViewName("Login");
            modelAndView.addObject("error","Information incorrecte");
        } else {
            session.setAttribute("admin", list.get(0));
            List<Categorie> categories = hibernateDao.findAll(Categorie.class);
            modelAndView.addObject("admin", list.get(0));
            modelAndView.addObject("categories", categories);
            modelAndView.setViewName("AjoutContenu");
        }

        return modelAndView;
    }

    @GetMapping("/deconnexion")
    public ModelAndView deconnexion(HttpSession session){
        session.removeAttribute("admin");

        return this.home();
    }
}
