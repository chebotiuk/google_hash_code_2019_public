package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.util.List;

public class Main
{
  private static final InputReader inputReader = new FileReader();
  private static final OutputWriter outputWriter = new OutputWriterImpl();
  private static final SlidesBuilder slidesBuilder = new MaxFinalTagsSlidesBuilder(10);
  private static final SlideShowBuilder slidesShowBuilder = new GreedySlideShowBuilder();
  private static final PointsCounter pointsCounter = new PointsCounter();

  public static void main( String[] args )
  {
//    solve( "a_example.txt", "a_result.txt" );
//    System.out.println( "Solved A" );
    solve( "b_lovely_landscapes.txt", "b_result.txt" );
    System.out.println( "Solved B" );
//    solve( "c_memorable_moments.txt", "c_result.txt" );
//    System.out.println( "Solved C" );
//    solve( "d_pet_pictures.txt", "d_result.txt" );
//    System.out.println( "Solved D" );
//    solve( "e_shiny_selfies.txt", "e_result.txt" );
//    System.out.println( "Solved E" );
  }

  public static void solve( String input, String output )
  {
    final List<Photo> photos = inputReader.readPhotos( input );

    final List<Slide> slides = slidesBuilder.build(photos);
    final Slideshow slideshow = slidesShowBuilder.build(slides);
    long points = pointsCounter.countPoints(slideshow);
    System.out.println("Received - " + points + " points");
    outputWriter.writeResult( slideshow, output );
  }
}
