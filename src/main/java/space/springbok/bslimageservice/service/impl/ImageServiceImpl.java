package space.springbok.bslimageservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import space.springbok.bslimageservice.config.PredefinedImageTypeConfig;
import space.springbok.bslimageservice.exception.NotFoundException;
import space.springbok.bslimageservice.model.ImageInfo;
import space.springbok.bslimageservice.model.Type;
import space.springbok.bslimageservice.service.AmazonS3ImageService;
import space.springbok.bslimageservice.service.ImageService;
import space.springbok.bslimageservice.service.LogService;

@Slf4j
@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(PredefinedImageTypeConfig.class)
public class ImageServiceImpl implements ImageService {

    private final AmazonS3ImageService awsImageService;

    private final LogService logService;

    private final PredefinedImageTypeConfig config;

    @Override
    public ImageInfo show(String predefinedType, String reference) {

        HttpHeaders headers = new HttpHeaders();

        if (predefinedType.equals("thumbnail")) {
            if (config.getThumbnail().getType() == Type.JPG) {
                headers.setContentType(MediaType.IMAGE_JPEG);
            } else if (config.getThumbnail().getType() == Type.GIF) {
                headers.setContentType(MediaType.IMAGE_GIF);
            } else if (config.getThumbnail().getType() == Type.PNG) {
                headers.setContentType(MediaType.IMAGE_PNG);
            }
        } else {
            logService.log("info", "The requested predefined image type does not exist:" + predefinedType);
            throw new NotFoundException("The requested predefined image type does not exist:" + predefinedType);
        }

        return ImageInfo.builder()
                .headers(headers)
                .image(awsImageService.show(reference))
                .build();
    }
}
