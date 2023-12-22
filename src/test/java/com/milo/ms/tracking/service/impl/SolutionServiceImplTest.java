package com.milo.ms.tracking.service.impl;

import com.milo.ms.tracking.dto.CoordinateDto;
import com.milo.ms.tracking.dto.SatelliteDto;
import com.milo.ms.tracking.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {SolutionServiceImpl.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SolutionServiceImplTest {

    @Autowired
    SolutionService solutionService;

    @Test
    void test() {
        var sputnik = SatelliteDto.builder().name("sputnik").distance(100d).build();
        var explorer = SatelliteDto.builder().name("explorer").distance(115.5).build();
        var asterix = SatelliteDto.builder().name("asterix").distance(142.7).build();

        var satellites = List.of(sputnik, explorer, asterix);
        CoordinateDto expected = null;
        var actual = assertDoesNotThrow(() -> solutionService.getLocation(satellites));

        assertAll(() -> assertEquals(expected, actual));
    }
}