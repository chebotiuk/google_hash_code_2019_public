package rainbow.ponies.model;

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
  public String toString() {
    return "Photo{" +
            "id=" + id +
            ", isVertical=" + isVertical +
            ", tags=" + tags +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Photo photo = (Photo) o;

    if (id != photo.id) return false;
    if (isVertical != photo.isVertical) return false;
    return tags != null ? tags.equals(photo.tags) : photo.tags == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (isVertical ? 1 : 0);
    result = 31 * result + (tags != null ? tags.hashCode() : 0);
    return result;
  }
}
