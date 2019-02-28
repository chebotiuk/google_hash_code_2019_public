package rainbow.ponies;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.stream.Collectors;

public class OutputWriterImpl implements OutputWriter
{
  public void writeResult( Slideshow slideshow, String resultFileName )
  {
    try (PrintWriter writer = new PrintWriter( new File( this.getClass().getResource( resultFileName ).getPath() ) ))
    {
      writer.println( slideshow.getSlides().size() ); // write number of slides
      for( Slide slide : slideshow.getSlides() ) // write each slide
      {
        final String photoIds = slide.getPhotos().stream()
                .map( Photo::getId )
                .map( String::valueOf )
                .collect( Collectors.joining( " " ) );

        writer.println( photoIds );
      }
    }
    catch( FileNotFoundException e )
    {
      throw new UncheckedIOException( e );
    }
  }
}
