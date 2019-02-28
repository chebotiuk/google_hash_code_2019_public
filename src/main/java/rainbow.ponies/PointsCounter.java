package rainbow.ponies;

import java.util.HashSet;
import java.util.List;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

public class PointsCounter {

    long countPoints (Slideshow slideshow) {// TODO test
        long points = 0;
        List<Slide> slides = slideshow.getSlides();
        for(int i = 0; i < slides.size()-1; i++) {
            points += countPoints(slides.get(i), slides.get(i+1));
        }

        return 1l;
    }

    long countPoints (Slide s1, Slide s2) {        // TODO test

        HashSet<String> left = new HashSet<>(s1.getTags());
        left.removeAll(s2.getTags());


        HashSet<String> right = new HashSet<>(s2.getTags());
        right.removeAll(s1.getTags());

        HashSet<String> middle = new HashSet<>(s1.getTags());
        middle.retainAll(s2.getTags());


        return min(left.size(), middle.size(), right.size());
    }

    long min(long l1, long l2, long l3) {
        return 1l; // TODO test
    }
}
