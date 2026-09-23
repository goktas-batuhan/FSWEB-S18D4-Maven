package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void checkBurger(Burger burger) {
        if (burger == null || burger.getName() == null || burger.getName().trim().isEmpty()) {
            throw new BurgerException("Burger name cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
    }
}
