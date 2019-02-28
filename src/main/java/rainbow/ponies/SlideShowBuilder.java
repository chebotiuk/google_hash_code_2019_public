package rainbow.ponies;

import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.List;

public interface SlideShowBuilder {

    Slideshow build ( List<Slide> slides);
}
