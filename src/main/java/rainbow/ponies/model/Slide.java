package rainbow.ponies.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Slide
{
  private final List<Photo> photos;

  public Slide( List<Photo> photos )
  {
    this.photos = photos;
  } // TODO verify there is no error

  public Slide(Photo photo){
      this.photos = Arrays.asList(photo);
  }

  public Slide(Photo photo1, Photo photo2){
    this.photos = Arrays.asList(photo1, photo2);
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
