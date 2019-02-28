package rainbow.ponies;

import rainbow.ponies.model.Photo;

import java.util.List;

public interface InputReader
{
  List<Photo> readPhotos( String inputFileName );
}
