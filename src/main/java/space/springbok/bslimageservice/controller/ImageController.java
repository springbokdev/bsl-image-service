package space.springbok.bslimageservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.springbok.bslimageservice.model.ImageInfo;
import space.springbok.bslimageservice.service.ImageService;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/image/show/{predefinedTypeName}")
    public ResponseEntity<byte[]> showImage(
            @RequestParam String reference,
            @PathVariable String predefinedTypeName) {
        log.debug("Show the image for reference {}", reference);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        ImageInfo imageInfo = imageService.show(predefinedTypeName, reference);
        return new ResponseEntity<>(imageInfo.getImage(), imageInfo.getHeaders(), HttpStatus.OK);
    }

}
