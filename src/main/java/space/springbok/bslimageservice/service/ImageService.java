package space.springbok.bslimageservice.service;

import space.springbok.bslimageservice.model.ImageInfo;

public interface ImageService {
    ImageInfo show(String predefinedType, String reference);
}
