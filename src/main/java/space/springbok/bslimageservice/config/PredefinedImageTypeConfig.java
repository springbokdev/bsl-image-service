package space.springbok.bslimageservice.config;


import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import space.springbok.bslimageservice.model.PredefinedImageType;

/**
 * To keep control over the amount of resized variants that are returned by the
 * Image service, it will only serve images with predefined values.
 */
@ConfigurationProperties(prefix="predefined-image-types")
@Getter
public class PredefinedImageTypeConfig {
    PredefinedImageType original = PredefinedImageType.builder()
            .build();

    PredefinedImageType thumbnail = PredefinedImageType.builder()
            .build();
}
