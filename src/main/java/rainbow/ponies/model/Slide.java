package rainbow.ponies.model;

import java.util.*;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Slide slide = (Slide) o;
    return Objects.equals(photos, slide.photos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(photos);
  }
}
