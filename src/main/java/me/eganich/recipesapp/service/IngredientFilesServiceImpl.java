package me.eganich.recipesapp.service;

import me.eganich.recipesapp.service.IngredientFilesService;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IngredientFilesServiceImpl implements IngredientFilesService {
        @Value("${path.to.recipe.data.file}")
        private String dataFilePath;
        @Value("${name.of.recipe.data.file}")
        private String dataFileName;

        @Override
        public boolean saveIngredientToFile(String json) {
            try {
                cleanDataFile();
                Files.writeString(Path.of(dataFilePath, dataFileName), json);
                return true;
            } catch (IOException e) {
                return false;
            }
        }
        @Override
        public String readIngredientFromFile() {
            try {
                return Files.readString(Path.of(dataFilePath, dataFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        public boolean cleanDataFile() {
            Path path = Path.of(dataFilePath, dataFileName);
            try {
                Files.deleteIfExists(path);
                Files.createFile(path);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }

        }
    }

