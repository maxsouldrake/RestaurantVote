package com.github.maxsouldrake.restaurantvote;

import com.github.maxsouldrake.restaurantvote.config.AppConfig;
import com.github.maxsouldrake.restaurantvote.config.PersistenceConfig;
import com.github.maxsouldrake.restaurantvote.service.MealService;
import com.github.maxsouldrake.restaurantvote.service.RestaurantService;
import com.github.maxsouldrake.restaurantvote.service.UserService;
import com.github.maxsouldrake.restaurantvote.service.VoteService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author SoulDrake
 * @create 2021-12-07 19:08
 **/

public class TestMain {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class, PersistenceConfig.class)) {
            MealService mealService = appCtx.getBean(MealService.class);
            RestaurantService restaurantService = appCtx.getBean(RestaurantService.class);
            UserService userService = appCtx.getBean(UserService.class);
            VoteService voteService = appCtx.getBean(VoteService.class);
        }
    }


}
