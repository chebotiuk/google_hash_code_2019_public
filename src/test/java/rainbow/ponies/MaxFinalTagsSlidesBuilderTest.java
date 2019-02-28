package rainbow.ponies;

import org.junit.Test;
import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class MaxFinalTagsSlidesBuilderTest {

    @Test
    public void testOnePhoto(){
        Photo photo = new Photo(1, true, new HashSet<>(Arrays.asList("tag1", "tag2", "tag3")));
        Photo photo2 = new Photo(2, true, new HashSet<>(Arrays.asList("tag1", "tag2", "tag5", "tag6")));
        Photo photo3 = new Photo(3, true, new HashSet<>(Arrays.asList("tag1", "tag2", "tag4")));
        MaxFinalTagsSlidesBuilder builder = new MaxFinalTagsSlidesBuilder();

        Collection<Slide> slides = builder.build(Arrays.asList(photo, photo3, photo2));
    }
}
