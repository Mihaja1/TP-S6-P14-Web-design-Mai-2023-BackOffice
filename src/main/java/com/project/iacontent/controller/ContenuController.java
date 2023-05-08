package com.project.iacontent.controller;

import com.project.iacontent.dao.HibernateDao;
import com.project.iacontent.model.Admin;
import com.project.iacontent.model.Categorie;
import com.project.iacontent.model.Contenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class ContenuController {

    @Autowired
    HibernateDao hibernateDao;

    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    @PostMapping("/ajoutContenu")
    public ModelAndView ajoutContenu(@ModelAttribute Contenu contenu) {
        Admin admin = hibernateDao.findById(Admin.class, contenu.getIdAdmin());
        Categorie categorie = hibernateDao.findById(Categorie.class, contenu.getIdCategorie());
        contenu.setAdmin(admin);
        contenu.setCategorie(categorie);
        LocalDateTime now = LocalDateTime.now();
        contenu.setDateAjout(Timestamp.valueOf(now));

        hibernateDao.create(contenu);

        List<Contenu> contenus = hibernateDao.findAll(Contenu.class);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contenus", contenus);
        modelAndView.setViewName("ListeContenu");

        return modelAndView;
    }

    @GetMapping("/listeContenu")
    public ModelAndView liste(){
        List<Contenu> contenus = hibernateDao.findAll(Contenu.class);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contenus", contenus);
        modelAndView.setViewName("ListeContenu");

        return modelAndView;
    }

    @GetMapping("details/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        Contenu contenu = hibernateDao.findById(Contenu.class, id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contenu", contenu);
        modelAndView.setViewName("DetailsContent");

        return modelAndView;
    }

    @GetMapping("/redirectAjout")
    public ModelAndView redirectAjout(HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");

        ModelAndView modelAndView = new ModelAndView();
        List<Categorie> categories = hibernateDao.findAll(Categorie.class);
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("admin", admin);
        modelAndView.setViewName("AjoutContenu");

        return modelAndView;
    }

    @GetMapping("modifier/{id}")
    public ModelAndView modifier(@PathVariable Integer id, HttpSession session) {
        Contenu contenu = hibernateDao.findById(Contenu.class, id);
        List<Categorie> categories = hibernateDao.findAll(Categorie.class);
        Admin admin = (Admin) session.getAttribute("admin");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("ModifierContenu");
        modelAndView.addObject("categories", categories);
        modelAndView.addObject("admin", admin);
        modelAndView.addObject("contenu", contenu);

        return modelAndView;
    }

    @GetMapping("supprimer/{id}")
    public ModelAndView supprimer(@PathVariable Integer id) {
        Contenu contenu = hibernateDao.findById(Contenu.class, id);
        List<Contenu> contenus = hibernateDao.findAll(Contenu.class);

        hibernateDao.delete(contenu);

        return this.liste();
    }

}
