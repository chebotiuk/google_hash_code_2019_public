package rainbow.ponies.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

  public Set<String> getTags(){
    Set<String> tags = new HashSet<String>();
    for(Photo photo : photos){
      tags.addAll(photo.getTags());
    }
    return tags;
  }
}
