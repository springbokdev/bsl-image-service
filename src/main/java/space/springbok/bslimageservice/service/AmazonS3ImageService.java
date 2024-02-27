package space.springbok.bslimageservice.service;

import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import space.springbok.bslimageservice.exception.NotFoundException;
import space.springbok.bslimageservice.utils.FileUtils;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AmazonS3ImageService extends AmazonClientService {

    private final LogService logService;

    public byte[] show(String reference) {
        String optimizedFileName = FileUtils.generateOptimizedFileName(reference);
        byte[] image = null;
        GetObjectRequest objectRequest = new GetObjectRequest(getBucketName(), optimizedFileName);

        try {
            S3Object s3Object = getClient().getObject(objectRequest);
            image = s3Object.getObjectContent().readAllBytes();
        } catch (IOException ioException) {;
            logService.log("info", "The reference does not exist:" + reference);
            throw new NotFoundException("The reference not exist:" + reference);
        } catch (AmazonS3Exception s3Exception) {
            logService.log("info", "The reference does not exist:" + reference);
            throw new NotFoundException("The reference not exist:" + reference);
        }

        return image;
    }
}
