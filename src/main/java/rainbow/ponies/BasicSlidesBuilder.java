package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BasicSlidesBuilder implements SlidesBuilder {
    @Override
    public Collection<Slide> build(Collection<Photo> photos) {
        Map<Boolean, List<Photo>> isVertical = photos.stream().collect(Collectors.groupingBy(Photo::isVertical));

        List<Photo> verticalPhotos = isVertical.get(true) == null ? new ArrayList<>() : isVertical.get(true);
        List<Photo> horizontalPhotos = isVertical.get(false) == null ? new ArrayList<>() : isVertical.get(false);

        Collection<Slide> slides = new ArrayList<>();
        horizontalPhotos.forEach(p -> slides.add(new Slide(p)));
        for(int i = 0; i < verticalPhotos.size()-1; i += 2){
            slides.add(new Slide(verticalPhotos.get(i), verticalPhotos.get(i+1)));
        }

        return slides;
    }
}
