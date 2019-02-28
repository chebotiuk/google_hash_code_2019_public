package rainbow.ponies;

import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.ArrayList;
import java.util.Collection;

public class BasicSlideShowBuilder implements SlideShowBuilder {
    @Override
    public Slideshow build(Collection<Slide> slides) {
        return new Slideshow(new ArrayList<>(slides));
    }
}
