package rainbow.ponies;


import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;

import java.util.Collection;

public interface SlidesBuilder {

    Collection<Slide> build(Collection<Photo> photos);
}
