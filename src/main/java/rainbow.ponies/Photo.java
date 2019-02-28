package rainbow.ponies;

import java.util.List;

public class Photo
{
  private final int id;
  private final boolean isVertical;
  private final List<String> tags;

  public Photo( int id, boolean isVertical, List<String> tags )
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

  public List<String> getTags()
  {
    return tags;
  }
}
