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
        // java 7 automatic resource management (ARM)
        try (AnnotationConfigApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class, PersistenceConfig.class)) {
//            System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));
            MealService mealService = appCtx.getBean(MealService.class);
            RestaurantService restaurantService = appCtx.getBean(RestaurantService.class);
            UserService userService = appCtx.getBean(UserService.class);
            VoteService voteService = appCtx.getBean(VoteService.class);

//            System.out.println(userService.getAll());
//            System.out.println(userService.get(100000));
//            System.out.println(userService.getByEmail("admin@gmail.com"))


            System.out.println("========================================");
            userService.get(100000);
            System.out.println("========================================");
            userService.delete(100000);
            System.out.println("========================================");
            userService.get(100000);
            System.out.println("========================================");




//            System.out.println("========================================");
//            voteService.get(100016,100000);
//            System.out.println("========================================");
//            voteService.delete(100016, 100000);
//            System.out.println("========================================");
//            voteService.get(100016,100000);
//            System.out.println("========================================");



////            System.out.println(vote.getId());
////            System.out.println(vote.getRestaurant());
////            System.out.println(vote.getUser());
//            System.out.println(vote.getDate());
//            System.out.println("========================================");
//            System.out.println(userService.getAll());
//            System.out.println(userService.getAll());
        }
    }


}
