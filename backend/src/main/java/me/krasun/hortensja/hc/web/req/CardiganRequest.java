package me.krasun.hortensja.hc.web.req;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CardiganRequest {

    private int totalRows;

    private int rowSize;

    @NotEmpty
    private List<Integer> colors;
}
