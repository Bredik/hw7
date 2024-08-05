package com.github.javarar.animal.faces;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public class AnimalFacesPipeline {
    //Время выполнения в один поток 28760ms
    public void load() throws IOException {
        File list[] = new File("task-2-animal-faces/src/main/resources/animal").listFiles();
        for (File l : list) {
            final BufferedImage image;
            image = ImageIO.read(l);
            var resizedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            var graphics2D = resizedImage.createGraphics();
            graphics2D.drawImage(image, 0, 0, 100, 100, null);
            graphics2D.dispose();
            var name = "task-2-animal-faces/src/main/resources/done/copy_" + l.getName();
            ImageIO.write(resizedImage, "jpg", new File(name));
        }
        ;
    }

    //Время выполнения в 20 потоков 3710ms
    public void loadAsync(ExecutorService executor) {
        File list[] = new File("task-2-animal-faces/src/main/resources/animal").listFiles();
        for (File l : list) {
            executor.submit(() -> {
                try {
                    final BufferedImage image;
                    image = ImageIO.read(l);
                    var resizedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                    var graphics2D = resizedImage.createGraphics();
                    graphics2D.drawImage(image, 0, 0, 100, 100, null);
                    graphics2D.dispose();
                    var name = "task-2-animal-faces/src/main/resources/done/copy_" + l.getName();
                    ImageIO.write(resizedImage, "jpg", new File(name));
                } catch (Exception e) {
                }
            });
        }
        executor.shutdown();
    }

    public void loadAsync_Two(ExecutorService executor) {
        File list[] = new File("task-2-animal-faces/src/main/resources/animal").listFiles();
        for (File l : list) {
            executor.submit(() -> {
                try {
                    final BufferedImage image;
                    image = ImageIO.read(l);
                    var resizedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
                    var graphics2D = resizedImage.createGraphics();
                    graphics2D.drawImage(image, 0, 0, 100, 100, null);
                    graphics2D.dispose();
                    var name = "task-2-animal-faces/src/main/resources/done/copy_" + l.getName();
                    ImageIO.write(resizedImage, "jpg", new File(name));
                } catch (Exception e) {
                }
            });
        }
        executor.shutdown();
    }
}
