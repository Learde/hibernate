package com.example.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
    @Autowired
    ClientORM clientORM;

    @GetMapping("/client/form")
    public String clientsForm() {
        return "form";
    }

    @GetMapping("/client/edit/{id}")
    public ModelAndView editPageClient(@PathVariable("id") Integer clientId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit");
        modelAndView.addObject("client", clientORM.getReferenceById(clientId)); // Добавляем модель данных

        return modelAndView;
    }

    @PostMapping("/client/add")
    public String addClient(@ModelAttribute("client") Client client) {
        clientORM.save(client);

        return "redirect:/";
    }

    @PostMapping("/client/edit/post/{id}")
    public String editClient(@PathVariable("id") Integer clientId, @ModelAttribute("client") Client client) {
        Client existing = clientORM.getById(clientId);
        existing.setPhone(client.getPhone());
        existing.setEmail(client.getEmail());
        existing.setName(client.getName());

        clientORM.save(existing);

        return "redirect:/";
    }

    @GetMapping("/")
    public ModelAndView clientsPage() {

//        clientORM.save(new Client("Pasha", "pasha@mail.ru", "+79911233322"));
//        clientORM.save(new Client("Vasya", "vasya@mail.ru", "+78005553535"));
//        clientORM.save(new Client("Senya", "senya@mail.ru", "+79338443312"));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("clients");
        modelAndView.addObject("clients", clientORM.findAll()); // Добавляем модель данных

        return modelAndView;
    }

    @PostMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") Integer clientId) {
        clientORM.deleteById(clientId);

        return "redirect:/"; // Перенаправление на другую страницу (например, список клиентов)
    }
}
