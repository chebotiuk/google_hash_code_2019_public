package rainbow.ponies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import rainbow.ponies.model.Photo;
import rainbow.ponies.model.Slide;
import rainbow.ponies.model.Slideshow;

public class UltimateGod implements MyGod {

    @Override
    public Slideshow formSlideshow(List<Photo> photos) {
        Set<Integer> usedPhotos = new HashSet<>();
        usedPhotos.add(photos.get(0).getId());
        Map<String, Set<Integer>> tagToPhotoId = getTagToPhoto(photos);
        Slideshow slideshow = new Slideshow(new ArrayList<>());
        Map<Integer, Photo> idToPhoto = photos.stream()
            .collect(Collectors.toMap(Photo::getId, o -> o));
        slideshow.add(new Slide(photos.get(0)));
        idToPhoto.remove(0);
        Photo nextPhoto = createSlideshow(slideshow, idToPhoto, photos.get(0),
            usedPhotos, tagToPhotoId);
        while (nextPhoto != null) {
            nextPhoto = createSlideshow(slideshow, idToPhoto, nextPhoto, usedPhotos, tagToPhotoId);
            if(nextPhoto == null)
                break;
        }
        return slideshow;
    }

    private Photo createSlideshow(Slideshow slideshow, Map<Integer, Photo> idToPhoto,
        Photo currentPhoto, Set<Integer> usedPhotos, Map<String, Set<Integer>> tagToPhotoId) {
        int photoWithMostCommonTags = getPhotoWithMostCommonTags(currentPhoto.getTags(),
            tagToPhotoId, usedPhotos);
        if (photoWithMostCommonTags == -1) {
            if (idToPhoto.keySet().isEmpty()) {
                return null;
            }
            photoWithMostCommonTags = idToPhoto.keySet().stream().findAny().get();
        }
        Photo nextPhoto = idToPhoto.get(photoWithMostCommonTags);
        idToPhoto.remove(photoWithMostCommonTags);
        slideshow.add(new Slide(nextPhoto));
        usedPhotos.add(photoWithMostCommonTags);
        return nextPhoto;
//        return createSlideshow(slideshow, idToPhoto, currentPhoto, usedPhotos, tagToPhotoId);
    }

    @Override
    public List<Slide> step1(List<Photo> photos) {
        return null;
    }

    @Override
    public Slideshow step2(List<Slide> slides) {
        return null;
    }

    private int getPhotoWithMostCommonTags(Set<String> tags, Map<String, Set<Integer>> tagToPhotoId,
        Set<Integer> usedPhotos) {
        Map<Integer, AtomicInteger> photoIdToNumberOfCommonTags = new HashMap<>();
        for (String tag : tags) {
            Set<Integer> ids = tagToPhotoId.get(tag);
            for (Integer id : ids) {
                if (usedPhotos.contains(id)) {
                    continue;
                }
                if (photoIdToNumberOfCommonTags.containsKey(id)) {
                    photoIdToNumberOfCommonTags.get(id).incrementAndGet();
                } else {
                    photoIdToNumberOfCommonTags.put(id, new AtomicInteger(1));
                }
            }
        }
        int currentMax = -1;
        int idWithMaxValue = -1;
        for (Entry<Integer, AtomicInteger> integerAtomicIntegerEntry : photoIdToNumberOfCommonTags
            .entrySet()) {
            if (integerAtomicIntegerEntry.getValue().get() > currentMax) {
                currentMax = integerAtomicIntegerEntry.getValue().get();
                idWithMaxValue = integerAtomicIntegerEntry.getKey();
            }
        }
        return idWithMaxValue;
    }

    private Map<String, Set<Integer>> getTagToPhoto(List<Photo> photos) {
        Map<String, Set<Integer>> tagToPhotoId = new HashMap<>();
        for (int i = 0; i < photos.size(); i++) {
            Photo photo = photos.get(i);
            Set<String> tags = photo.getTags();
            for (String tag : tags) {
                if (tagToPhotoId.containsKey(tag)) {
                    tagToPhotoId.get(tag).add(photo.getId());
                } else {
                    tagToPhotoId.put(tag, new HashSet<>(Arrays.asList(photo.getId())));
                }
            }
        }
        return tagToPhotoId;
    }
}
