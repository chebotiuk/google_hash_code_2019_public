package rainbow.ponies;

import rainbow.ponies.model.Slideshow;

public interface OutputWriter
{
  void writeResult( Slideshow slideshow, String resultFileName );
}
