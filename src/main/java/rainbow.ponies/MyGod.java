package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.List;

public interface MyGod
{
  Slideshow formSlideshow( List<Photo> photos );

  List<Slide> step1( List<Photo> photos );

  Slideshow step2( List<Slide> slides );
}
