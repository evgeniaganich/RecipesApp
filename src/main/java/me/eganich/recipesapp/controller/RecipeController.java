package me.eganich.recipesapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.eganich.recipesapp.model.Ingredient;
import me.eganich.recipesapp.model.Recipe;
import me.eganich.recipesapp.service.RecipeService;
import me.eganich.recipesapp.service.RecipeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/recipes")
@Tag(name="Рецепты", description =  "CRUD-операции и другие эндпоинты для работы с рецептами")
public class RecipeController {

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Поиск рецепта",
            description = "Поиск осуществляется по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт найден",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Рецепт не найден",
                    content = {}
            )
    }
    )
    public ResponseEntity<Recipe> getRecipe(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getRecipe(id));
    }
    @PostMapping
    @Operation(summary = "Добавление нового рецепта")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт добавлен",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Произошла ошибка",
                    content = {}
            )
    }
    )
    public ResponseEntity<Recipe> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(service.addRecipe(recipe));
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление рецепта",
            description = "Удаление осуществляется по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт удален"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Рецепт не найден"
            )
    }
    )
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(service.removeRecipe(id));
    }
    @PutMapping("/{id}")
    @Operation(
            summary = "Редактирование рецепта",
            description = "Редактирование осуществляется по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт отредактирован",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Произошла ошибка",
                    content = {}
            )
    }
    )
    public ResponseEntity<Recipe> updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(service.updateRecipe(id, recipe));
    }
    @GetMapping
    @Operation(summary = "Вывод всех рецептов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепты найдены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Recipe.class))
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Рецепты не найдены",
                    content = {}
            )
    }
    )
    public ResponseEntity<Collection<Recipe>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
}
