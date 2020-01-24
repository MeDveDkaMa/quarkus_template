package Handlers;

import Beans.Dish;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DishesHandler {

    @Inject
    Dish dish;



}
