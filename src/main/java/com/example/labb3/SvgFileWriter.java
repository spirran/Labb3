package com.example.labb3;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SvgFileWriter {

        FileChooser fileChooser = new FileChooser();

        List<String> svgString = new ArrayList<>();
        Path savePath;

        public void saveToFile(ShapeViewModel model, Stage stage) {
            createFileChooser();

            File filePath = fileChooser.showSaveDialog(stage);
            if (filePath != null) {
                savePath = filePath.toPath();
                buildString(model);
                saveFile();
            }
        }

        private void saveFile() {
            try {
                if (savePath.endsWith(".svg"))
                    Files.write(savePath, svgString);
                else
                    Files.write(Path.of(savePath + ".svg"), svgString);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void createFileChooser() {
            fileChooser.setTitle("Location to save file");
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(".svg Files", "*.svg"));
        }

        private void buildString(ShapeViewModel model) {
            svgString.add(svgStart());
            model.positionList.forEach(shape -> svgString.add(shape.toString()));
            System.out.println(model.positionList);
            svgString.add(svgEnd());
        }

        private static String svgStart() {
            return "<svg width=\"800.0\" height=\"600.0\" xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">";
        }

        private static String svgEnd() {
            return "</svg>";
        }




}
