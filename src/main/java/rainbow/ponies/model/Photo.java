package rainbow.ponies.model;

import java.util.Objects;
import java.util.Set;

public class Photo
{
  private final int id;
  private final boolean isVertical;
  private final Set<String> tags;

  public Photo( int id, boolean isVertical, Set<String> tags )
  {
    this.id = id;
    this.isVertical = isVertical;
    this.tags = tags;
  }

  public int getId()
  {
    return id;
  }

  public boolean isVertical()
  {
    return isVertical;
  }

  public Set<String> getTags()
  {
    return tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Photo photo = (Photo) o;
    return id == photo.id &&
            isVertical == photo.isVertical &&
            Objects.equals(tags, photo.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isVertical, tags);
  }
}
