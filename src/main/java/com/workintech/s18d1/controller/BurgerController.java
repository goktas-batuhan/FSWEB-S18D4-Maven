package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = {"/burger", "/workintech/burgers"})
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping
    public List<Burger> findAll() {
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable("id") Long id) {
        return burgerDao.findById(id);
    }

    @PostMapping
    public Burger save(@RequestBody Burger burger) {
        BurgerValidation.checkBurger(burger);
        return burgerDao.save(burger);
    }

    @PutMapping
    public Burger update(@RequestBody Burger burger) {
        BurgerValidation.checkBurger(burger);
        return burgerDao.update(burger);
    }

    @PutMapping("/{id}")
    public Burger updateWithId(@PathVariable("id") Long id, @RequestBody Burger burger) {
        BurgerValidation.checkBurger(burger);
        burger.setId(id);
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger remove(@PathVariable("id") Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable("breadType") BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByBreadType")
    public List<Burger> findByBreadTypeBody(@RequestBody(required = false) BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable("price") Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByPrice")
    public List<Burger> findByPriceBody(@RequestBody(required = false) Integer price) {
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable("content") String content) {
        return burgerDao.findByContent(content);
    }

    @GetMapping("/findByContent")
    public List<Burger> findByContentBody(@RequestBody(required = false) String content) {
        return burgerDao.findByContent(content);
    }
}
