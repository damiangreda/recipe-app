package guru.springframework.controllers;

import guru.springframework.domain.Difficulty;
import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IndexControllerTest {

    @Mock
    private RecipeService recipeService;
    private Recipe recipe;
    @Mock
    private Model model;
    private IndexController indexController;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipe = new Recipe();
        recipe.setDirections("Directions");
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setDescription("Some description");
        recipe.setPrepTime(10);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() {
        String viewName = indexController.getIndexPage(model);

        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute(eq("recipes"),anySet());
    }
}