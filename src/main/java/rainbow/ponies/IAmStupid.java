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
    Slide verticalSlide = null;
    for( Photo photo : photos )
    {
      if( photo.isVertical() )
      {
        if( verticalSlide == null )
        {
          verticalSlide = new Slide( new ArrayList<>() );
          verticalSlide.getPhotos().add( photo );
        }
        else
        {
          verticalSlide.getPhotos().add( photo );
          slides.add( verticalSlide );
          verticalSlide = null;
        }
      }
      else
      {
        final Slide slide = new Slide( Collections.singletonList( photo ) );
        slides.add( slide );
      }
    }

    return new Slideshow( slides );
  }

  @Override
  public List<Slide> step1( List<Photo> photos )
  {
    return null;
  }

  @Override
  public Slideshow step2( List<Slide> slides )
  {
    return null;
  }
}
