package rainbow.ponies.model;

import java.util.List;

public class Slideshow {

    private final List<Slide> slides;

    public Slideshow(List<Slide> slides) {
        this.slides = slides;
    }

    public List<Slide> getSlides() {
        return slides;
    }
}
