package rainbow.ponies;

import java.util.List;
import rainbow.ponies.model.Photo;

public interface InputReader
{
  List<Photo> readPhotos( String inputFileName );
}
