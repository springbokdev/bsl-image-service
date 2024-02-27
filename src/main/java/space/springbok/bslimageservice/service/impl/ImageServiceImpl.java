package space.springbok.bslimageservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import space.springbok.bslimageservice.config.PredefinedImageTypeConfig;
import space.springbok.bslimageservice.service.ImageService;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(PredefinedImageTypeConfig.class)
public class ImageServiceImpl implements ImageService {

    private final PredefinedImageTypeConfig config;
    @Override
    public void printInfo() {
        System.out.println("WIDTH: " + config.getThumbnail().getWidth());
        System.out.println("HEIGHT: " + config.getThumbnail().getHeight());
        System.out.println("QUALITY: " + config.getThumbnail().getQuality());
        System.out.println("TYPE: " + config.getThumbnail().getType());
        System.out.println("SCALE_TYPE: " + config.getThumbnail().getScaleType());
        System.out.println("FILL_COLOR: " + config.getThumbnail().getFillColor());
    }
}
