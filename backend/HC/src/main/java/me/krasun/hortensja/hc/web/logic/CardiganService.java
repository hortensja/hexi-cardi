package me.krasun.hortensja.hc.web.logic;

import java.awt.image.BufferedImage;

import org.springframework.stereotype.Service;

import me.krasun.hortensja.hc.web.req.CardiganRequest;

@Service
public class CardiganService {

    public BufferedImage generateImage(CardiganRequest req) {
        final var totalRows = req.getTotalRows();
        final var rowSize = req.getRowSize();
        final var numberOfColors = req.getColors()
                .size();

        BufferedImage img = new BufferedImage(req.getTotalRows(), totalRows, BufferedImage.TYPE_INT_RGB);

        //create image pixel by pixel
        for (int x = 0; x < totalRows; x++) {
            for (int y = 0; y < totalRows; y++) {
                var color = req.getColors()
                        .get(Math.max(x, y) / rowSize % numberOfColors);

                img.setRGB(x, y, color);
            }
        }
        return img;
    }
}
