package space.springbok.bslimageservice.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpHeaders;

@Data
@Builder
public class ImageInfo {

    private byte[] image;
    private HttpHeaders headers;
}
