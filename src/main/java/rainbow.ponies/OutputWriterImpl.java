package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.stream.Collectors;

public class OutputWriterImpl implements OutputWriter
{
  public void writeResult( Slideshow slideshow, String resultFileName )
  {
    final File result = new File( this.getClass().getClassLoader().getResource( resultFileName ).getPath() );
    try (PrintWriter writer = new PrintWriter( result ))
    {
      writer.println( slideshow.getSlides().size() ); // write number of slides
      System.out.println( slideshow.getSlides().size() );
      for( Slide slide : slideshow.getSlides() ) // write each slide
      {
        final String photoIds = slide.getPhotos().stream()
                .map( Photo::getId )
                .map( String::valueOf )
                .collect( Collectors.joining( " " ) );

        writer.println( photoIds );
        System.out.println( photoIds );
      }
    }
    catch( FileNotFoundException e )
    {
      throw new UncheckedIOException( e );
    }
  }
}
