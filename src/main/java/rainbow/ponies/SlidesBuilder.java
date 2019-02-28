package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;

import java.util.List;

public interface SlidesBuilder {

    List<Slide> build( List<Photo> photos);
}
