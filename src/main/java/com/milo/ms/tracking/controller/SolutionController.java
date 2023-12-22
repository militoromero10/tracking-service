package com.milo.ms.tracking.controller;

import com.milo.ms.tracking.dto.RequestDto;
import com.milo.ms.tracking.dto.ResponseDto;
import com.milo.ms.tracking.exceptions.SolutionException;
import com.milo.ms.tracking.service.SolutionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
public class SolutionController {
    public static final String BASE_URL_TRACKING = "/tracking";

    private final SolutionService solutionService;

    @PostMapping(BASE_URL_TRACKING)
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto getSolution(@RequestBody RequestDto requestDto) {
        var sol = solutionService.getLocation(requestDto.getSatellites());
        return ResponseDto.builder().position(sol).build();
    }

    @GetMapping(path = "/error")
    @ResponseStatus(HttpStatus.OK)
    public void getSolutionError() {
        throw new SolutionException("Boom!");
    }

}
