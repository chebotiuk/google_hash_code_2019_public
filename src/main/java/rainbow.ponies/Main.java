package rainbow.ponies;

import java.util.List;

public class Main
{
  private static final InputReader inputReader = null;
  private static final MyGod myGod = null;
  private static final OutputWriter outputWriter = null;

  public static void main( String[] args )
  {
    final List<Photo> photos = inputReader.readPhotos( "a_example.txt" );
    final Slideshow slideshow = myGod.formSlideshow( photos );
    outputWriter.writeResult( slideshow, "a_result.txt" );
  }
}
