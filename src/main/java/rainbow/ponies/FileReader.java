package rainbow.ponies;

import rainbow.ponies.model.Photo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class FileReader implements InputReader {

    @Override
    public List<Photo> readPhotos(String inputFileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(inputFileName).getFile());
        List<Photo> photos = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            int numberOfPhotos = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numberOfPhotos; i++) {
                String row = scanner.nextLine();
                String[] parts = row.split(" ");
                boolean isVertical = "V".equals(parts[0]);
                Set<String> tags = Arrays.stream(parts)
                    .skip(2)
                    .collect(Collectors.toSet());
                photos.add(new Photo(i, isVertical, tags));
            }
            return photos;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
