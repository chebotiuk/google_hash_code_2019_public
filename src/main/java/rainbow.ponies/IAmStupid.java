package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IAmStupid implements MyGod
{
  @Override
  public Slideshow formSlideshow( List<Photo> photos )
  {
    List<Slide> slides = new ArrayList<>();
    for( Photo photo : photos )
    {
      final Slide slide = new Slide( Collections.singletonList( photo ) );
      slides.add( slide );
    }

    return new Slideshow( slides );
  }
}
