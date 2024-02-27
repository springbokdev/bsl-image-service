package space.springbok.bslimageservice.service;

import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.springbok.bslimageservice.utils.FileUtils;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
public class AmazonS3ImageService extends AmazonClientService {

    public void uploadImageToAmazon(MultipartFile multipartFile) {

        // Upload file to Amazon.
        String url = uploadMultipartFile(multipartFile);

    }

    // Make upload to Amazon.
    private String uploadMultipartFile(MultipartFile multipartFile) {
        String fileUrl = "";

        try {
            // Get the file from MultipartFile.
            File file = FileUtils.convertMultipartToFile(multipartFile);

            // Extract the file name.
            String fileName = FileUtils.generateFileName(multipartFile);

            // Upload file.
            uploadPublicFile(fileName, file);

            // Delete the file and get the File Url.
            file.delete();
            fileUrl = getUrl().concat(fileName);
        } catch (IOException e) {
            // TODO implement proper handling

        }

        return fileUrl;
    }


    private void uploadPublicFile(String fileName, File file) {
        getClient().putObject(new PutObjectRequest(getBucketName(), fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

    private void getPublicFile() {
//

    }
}
