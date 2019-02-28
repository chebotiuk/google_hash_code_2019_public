package rainbow.ponies;

import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GreedySlideShowBuilder implements SlideShowBuilder
{
  @Override
  public Slideshow build( List<Slide> slides )
  {
    final Random random = new Random();
    final Slideshow slideshow = new Slideshow( new ArrayList<>() );
    slideshow.getSlides().add( slides.remove( 0 ) );

    here:
    while( !slides.isEmpty() )
    {
      long bestResult = -Integer.MAX_VALUE;
      Slide bestNextMatch = null;
      for( int i = 0; i < slides.size(); i+=100 )
      {
        final List<Slide> existingSlides = new ArrayList<>();
        existingSlides.add( slideshow.getSlides().get( slideshow.getSlides().size() - 1 ) );
        final Slide nextSlide = slides.get( i );
        existingSlides.add( nextSlide );
        final long result = new PointsCounter().countPoints( new Slideshow( existingSlides ) );
        if( result > bestResult )
        {
          bestNextMatch = nextSlide;
          bestResult = result;
          if( result >= 3 )
            break;
        }
      }

      slideshow.getSlides().add( bestNextMatch );
      slides.remove( bestNextMatch );

//      if( slides.size() % 1000 == 0 )
//      {
        System.out.println( "Left: " + slides.size() );
        System.out.println( "Best result so far: " + bestResult );
//      }
    }

    return slideshow;
  }
}
