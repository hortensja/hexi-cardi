package me.krasun.hortensja.hc.web;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.krasun.hortensja.hc.web.logic.CardiganService;
import me.krasun.hortensja.hc.web.req.CardiganRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cardigan")
@Slf4j
public class CardiganController {

    private final CardiganService cardiganService;

    @PostMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] generateImage(@RequestBody CardiganRequest req) throws IOException {

        final var img = cardiganService.generateImage(req);

        //write image

        File f = null;
        try {
            f = new File("output.png");
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            log.error("Error: " + e);
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, "png", baos);
        return baos.toByteArray();
    }

    @GetMapping
    public String healthCheck() {
        return "yooo";
    }
}
