package rainbow.ponies;

import java.util.List;

public class Photo
{
  private final boolean isVertical;
  private final List<String> tags;

  public Photo( boolean isVertical, List<String> tags )
  {
    this.isVertical = isVertical;
    this.tags = tags;
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
