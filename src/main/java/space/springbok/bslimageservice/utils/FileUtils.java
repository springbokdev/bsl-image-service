package space.springbok.bslimageservice.utils;

import lombok.experimental.UtilityClass;
import lombok.val;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

@UtilityClass
public class FileUtils {

    private static final String THUMBNAIL_PREFIX = "/thumbnail/";

    public static File convertMultipartToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fileOutputStream = new FileOutputStream(convertedFile);
        fileOutputStream.write(file.getBytes());
        fileOutputStream.close();
        return convertedFile;
    }

    public static String generateFileName(MultipartFile multipartFile) {
        return new Date().getTime() + "-" + Objects.requireNonNull(multipartFile.getOriginalFilename()).replace(" ", "_");
    }

    public static String generateOptimizedFileName(String uniqueOriginalFileName) {
        var optimizedFileName = new StringBuilder(THUMBNAIL_PREFIX);
        val fileNameWithoutExtension = withoutExtension(uniqueOriginalFileName.replace('/', '_'));

        if (fileNameWithoutExtension.length() <= 4) {
            optimizedFileName = optimizedFileName.append(fileNameWithoutExtension).append(fileExtension(uniqueOriginalFileName));
        } else if (fileNameWithoutExtension.length() > 8) {
            optimizedFileName = optimizedFileName.append(firstDirectory(fileNameWithoutExtension))
                    .append("/")
                    .append(secondDirectory(fileNameWithoutExtension))
                    .append("/")
                    .append(fileNameWithoutExtension)
                    .append(fileExtension(uniqueOriginalFileName));

        } else if (fileNameWithoutExtension.length() > 4 && fileNameWithoutExtension.length() <= 8) {
            optimizedFileName = optimizedFileName.append(firstDirectory(fileNameWithoutExtension))
                    .append("/")
                    .append(fileNameWithoutExtension)
                    .append(fileExtension(uniqueOriginalFileName))
            ;
        }

        return optimizedFileName.toString();
    }

    private static String withoutExtension(String fileName) {
        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex == -1) {
            return fileName; // No extension found
        }
        return fileName.substring(0, extensionIndex);
    }

    private static String firstDirectory(String fileName) {
        return fileName.substring(0,4);
    }

    private static String secondDirectory(String fileName) {
        return fileName.substring(4,8);
    }

    private static String fileExtension(String uniqueOriginalFileName) {
        return uniqueOriginalFileName.substring(uniqueOriginalFileName.lastIndexOf('.'));
    }

}
