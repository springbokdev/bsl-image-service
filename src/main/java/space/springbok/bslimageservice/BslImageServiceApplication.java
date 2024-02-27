package space.springbok.bslimageservice;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import space.springbok.bslimageservice.service.ImageService;

@SpringBootApplication
@RequiredArgsConstructor
public class BslImageServiceApplication implements CommandLineRunner {

    private final ImageService imageService;
    public static void main(String[] args) {
        SpringApplication.run(BslImageServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        imageService.printInfo();;
    }
}
