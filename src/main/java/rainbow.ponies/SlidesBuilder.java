package rainbow.ponies;

import java.util.Collection;

public interface SlidesBuilder {

    Collection<Slide> build(Collection<Photo> photos);
}
