package rainbow.ponies;

import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class GreedySlideShowBuilder implements SlideShowBuilder
{
  @Override
  public Slideshow build( List<Slide> slides )
  {
    System.out.println( new Date() + ": Left: " + slides.size() );

    final Slideshow slideshow = new Slideshow( new ArrayList<>() );
    slideshow.getSlides().add( slides.remove( 0 ) );

    while( !slides.isEmpty() )
    {
      final long[] bestResult = { -Integer.MAX_VALUE };
      final Slide[] bestNextMatch = { null };

      IntStream.range( 0, slides.size() )
              .parallel()
              .forEach( i -> {
                final List<Slide> existingSlides = new ArrayList<>();
                existingSlides.add( slideshow.getSlides().get( slideshow.getSlides().size() - 1 ) );
                final Slide nextSlide = slides.get( i );
                existingSlides.add( nextSlide );
                final long result = new PointsCounter().countPoints( new Slideshow( existingSlides ) );
                if( result > bestResult[ 0 ] )
                {
                  bestNextMatch[ 0 ] = nextSlide;
                  bestResult[ 0 ] = result;
                }
              } );

      slideshow.getSlides().add( bestNextMatch[ 0 ] );
      slides.remove( bestNextMatch[ 0 ] );

      if( slides.size() % 100 == 0 )
      {
        System.out.println( new Date() + ": Left: " + slides.size() );
      }
    }

    return slideshow;
  }
}
