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
    final List<Photo> photos = inputReader.readPhotos( "a_example.txt" );
    final Slideshow slideshow = myGod.formSlideshow( photos );
    outputWriter.writeResult( slideshow, "a_result.txt" );
  }
}
