package space.springbok.bslimageservice.model;

import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
public class PredefinedImageType {

    private int height;
    private int width;
    private long quality;
    private ScaleType scaleType;
    private String fillColor;
    private Type type;

    private enum ScaleType {
        CROP,
        FILL,
        SKEW;
    }

    private enum Type {
        JPG,
        PNG,
        GIF;
    }

}
