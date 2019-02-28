package rainbow.ponies;

import java.util.List;

public class PointsCounter {

    long countPoints (Slideshow slideshow) {// TODO test
        long points = 0;
        List<Slide> slides = slideshow.getSlides();
        for(int i = 0; i < slides.size()-1; i++) {
            points += countPoints(slides.get(i), slides.get(i+1));
        }

        return 1l;
    }

    long countPoints (Slide s1, Slide s2) {
        return 1;
        // TODO test
    }
}
