package rainbow.ponies;

import java.util.List;

public class Slide
{
  private final List<Photo> photos;

  public Slide( List<Photo> photos )
  {
    this.photos = photos;
  }

  public List<Photo> getPhotos()
  {
    return photos;
  }
}
