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
import me.eganich.recipesapp.service.IngredientService;
import me.eganich.recipesapp.service.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/ingredients")
@Tag(name = "Ингредиенты", description =  "CRUD-операции и другие эндпоинты для работы с ингредиентами")
public class IngredientController {

    private final IngredientService service;

    public IngredientController(IngredientService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Поиск ингредиента",
            description = "Поиск осуществляется по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент найден",
                    content = {
                            @Content(
                                    mediaType = "application/json"
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ингредиент не найден",
                    content = {}
            )
    }
    )
    public ResponseEntity<Ingredient> getIngredient(@PathVariable int id) {
        return ResponseEntity.ok().body(service.getIngredient(id));
    }
    @PostMapping
    @Operation(summary = "Добавление нового ингредиента")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент добавлен",
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
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        return ResponseEntity.ok().body(service.addIngredient(ingredient));
    }
    @GetMapping
    @Operation(summary = "Вывод всех ингредиентов")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиенты найдены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
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
    public ResponseEntity<Collection<Ingredient>> getAll() {
        return ResponseEntity.ok().body(service.getAll());
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удаление ингредиента",
            description = "Удаление осуществляется по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент удален"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ингредиент не найден"
            )
    }
    )
    public ResponseEntity<Ingredient> deleteIngredient(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(service.removeIngredient(id));
    }
    @PutMapping("/{id}")
    @Operation(
            summary = "Редактирование ингредиента",
            description = "Редактирование осуществляется по id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент отредактирован",
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
    public ResponseEntity<Ingredient> updateRecipe(@PathVariable("id") int id, @RequestBody Ingredient ingredient) {
        return ResponseEntity.ok().body(service.updateIngredient(id, ingredient));
    }
}
