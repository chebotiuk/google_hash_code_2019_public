package rainbow.ponies;

import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.Collection;

public interface SlideShowBuilder {

    Slideshow build (Collection<Slide> slides);
}
