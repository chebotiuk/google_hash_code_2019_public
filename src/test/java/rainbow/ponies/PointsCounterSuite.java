package rainbow.ponies;

import org.junit.Test;
import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

public class PointsCounterSuite {

    private PointsCounter counter = new PointsCounter();

    @Test
    public void countPointsSlideshowTest() {
        Slide slide1 = new Slide(
                new ArrayList<>(Arrays.asList(new Photo(0,false, new HashSet<>(Arrays.asList("1", "2", "3")))))
        );

        Slide slide2 = new Slide(
                new ArrayList<>(
                        Arrays.asList(
                                new Photo(1, true, new HashSet<>(Arrays.asList("4", "5"))),
                                new Photo(2, true, new HashSet<>(Arrays.asList("1", "3", "2")))
                        )
                )
        );

        Slide slide3 = new Slide(
                new ArrayList<>(
                        Arrays.asList(
                                new Photo(4, false, new HashSet<>(Arrays.asList("4", "5", "6", "7")))
                        )
                )
        );

        Slideshow slideshow = new Slideshow(Arrays.asList(slide1, slide2, slide3));

        assertEquals(0, counter.countPoints(slide1, slide2)); // min 0, 3, 2
        assertEquals(2, counter.countPoints(slide2, slide3)); // min 3, 2, 2

        assertEquals(2, counter.countPoints(slideshow));
    }
}
