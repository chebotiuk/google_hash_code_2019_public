package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slideshow;

import java.util.List;

public class Main
{
  private static final InputReader inputReader = new FileReader();
  private static final MyGod myGod = new IAmStupid();
  private static final OutputWriter outputWriter = new OutputWriterImpl();

  public static void main( String[] args )
  {
    solve( "a_example.txt", "a_result.txt" );
    System.out.println( "Solved A" );
    solve( "b_lovely_landscapes.txt", "b_result.txt" );
    System.out.println( "Solved B" );
    solve( "c_memorable_moments.txt", "c_result.txt" );
    System.out.println( "Solved C" );
    solve( "d_pet_pictures.txt", "d_result.txt" );
    System.out.println( "Solved D" );
    solve( "e_shiny_selfies.txt", "e_result.txt" );
    System.out.println( "Solved E" );
  }

  public static void solve( String input, String output )
  {
    final List<Photo> photos = inputReader.readPhotos( input );
    final Slideshow slideshow = myGod.formSlideshow( photos );
    outputWriter.writeResult( slideshow, output );
  }
}
