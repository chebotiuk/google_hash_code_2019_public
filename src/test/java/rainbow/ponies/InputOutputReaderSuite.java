package rainbow.ponies;

import org.junit.Test;
import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public final class InputOutputReaderSuite {
    private final InputReader reader = new FileReader();
    private final OutputWriter writer = new OutputWriterImpl();

    @Test
    public void testInput() {
        List<Photo> photos = reader.readPhotos("a_example.txt");
        assertTrue(4 == photos.size());
        assertEquals(new Photo(0, false, new HashSet<>(Arrays.asList("cat", "beach", "sun"))), photos.get(0));
        assertEquals(new Photo(1, true, new HashSet<>(Arrays.asList("selfie", "smile"))), photos.get(1));
        assertEquals(new Photo(2, true, new HashSet<>(Arrays.asList("garden", "selfie"))), photos.get(2));
        assertEquals(new Photo(3, false, new HashSet<>(Arrays.asList("garden", "cat"))), photos.get(3));
    }

    @Test
    public void testOutput() throws IOException {

        Slide slide1 = new Slide(
                new ArrayList<>(Arrays.asList(new Photo(0,false, new HashSet<>(Arrays.asList("cat", "beach", "sun")))))
                );

        Slide slide2 = new Slide(
                new ArrayList<>(
                        Arrays.asList(
                                new Photo(1, true, new HashSet<>(Arrays.asList("selfie", "smile"))),
                                new Photo(2, true, new HashSet<>(Arrays.asList("cat", "beach", "sun")))
                        )
                )
        );

        Slide slide3 = new Slide(
                new ArrayList<>(Arrays.asList(new Photo(3,false, new HashSet<>(Arrays.asList("cat", "beach", "sun")))))
        );


        Slideshow slideshow = new Slideshow(Arrays.asList(slide1, slide2, slide3));

        writer.writeResult(slideshow, "result.txt");

        assertEquals(
                new ArrayList<>(Arrays.asList(
                        String.valueOf(slideshow.getSlides().size()),
                        String.valueOf(slide1.getPhotos().get(0).getId()),
                        String.valueOf(slide2.getPhotos().get(0).getId()) + " " + String.valueOf(slide2.getPhotos().get(1).getId()),
                        String.valueOf(slide3.getPhotos().get(0).getId())
                )),
                readLines("result.txt")
        );
    }


    private List<String> readLines(String inputFileName) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(inputFileName).getFile());
        return Files.readAllLines(file.toPath());
    }
}
