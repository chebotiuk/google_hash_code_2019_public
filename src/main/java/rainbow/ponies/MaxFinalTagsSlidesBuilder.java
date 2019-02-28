package rainbow.ponies;

import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;

import java.util.*;
import java.util.stream.Collectors;

public class MaxFinalTagsSlidesBuilder implements SlidesBuilder {

    private final int maxAttempts;

    public MaxFinalTagsSlidesBuilder(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    @Override
    public Collection<Slide> build(Collection<Photo> photos) {
        Map<Boolean, List<Photo>> isVertical = photos.stream().collect(Collectors.groupingBy(Photo::isVertical));

        List<Photo> verticalPhotos = isVertical.get(true) == null ? new ArrayList<>() : isVertical.get(true);
        List<Photo> horizontalPhotos = isVertical.get(false) == null ? new ArrayList<>() : isVertical.get(false);

        Collection<Slide> slides = new ArrayList<>();
        horizontalPhotos.forEach(p -> slides.add(new Slide(p)));

        verticalPhotos = new ArrayList<>(verticalPhotos);
        while(verticalPhotos.size() > 0){

            Photo first = verticalPhotos.remove(0);

            Photo best = null;
            long maxTags = -1;
            for(int i = 0; i < maxAttempts && i < verticalPhotos.size(); i++){
                Photo candidate = verticalPhotos.get(i);
                Set<String> tags = new HashSet<>(first.getTags());
                tags.addAll(candidate.getTags());
                if(maxTags < tags.size()){
                    best = candidate;
                    maxTags = tags.size();
                }
            }
            if(best != null){
                slides.add(new Slide(first, best));
                verticalPhotos.remove(best);
            }
        }




//        for(int i = 0; i < verticalPhotos.size()-1; i += 2){
//            slides.add(new Slide(verticalPhotos.get(i), verticalPhotos.get(i+1)));
//        }






        return slides;
    }
}
