package com.example.hibernatetest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    // metodo controller per visualizzare il form html iniziale

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // metodo controller per processare il form html

    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // metodo controller per leggere i dati nel form e
    // aggiungere i dati al model

    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // leggere parametro request dal form HTML
        String theName=request.getParameter("studentName");

        // convertire i dati in MAIUSCOLO
        theName=theName.toUpperCase();

        // creare il messaggio
        String result = "Yo! " + theName;

        // aggiungere messaggio al model
        model.addAttribute("message", result);

        return "helloworld";
    }
    @RequestMapping("/processFormV3")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model){

        // convertire i dati in MAIUSCOLO
        theName=theName.toUpperCase();

        // creare il messaggio
        String result = "V3 message " + theName;

        // aggiungere messaggio al model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
