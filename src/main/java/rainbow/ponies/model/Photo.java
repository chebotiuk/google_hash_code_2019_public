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
}
