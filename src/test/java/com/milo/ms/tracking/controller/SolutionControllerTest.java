package com.milo.ms.tracking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milo.ms.tracking.dto.CoordinateDto;
import com.milo.ms.tracking.dto.RequestDto;
import com.milo.ms.tracking.dto.SatelliteDto;
import com.milo.ms.tracking.service.SolutionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(SolutionController.class)
class SolutionControllerTest {
    @Autowired
    MockMvc controller;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    SolutionService solutionService;


    @Test
    void getBeerById() throws Exception {

        var solve = CoordinateDto.builder().x(-100d).y(75.5).build();
        var sputnik = SatelliteDto.builder().name("sputnik").distance(100d).build();
        var explorer = SatelliteDto.builder().name("explorer").distance(115.5).build();
        var asterix = SatelliteDto.builder().name("asterix").distance(142.7).build();

        var satellites = List.of(sputnik, explorer, asterix);
        var requestBody = objectMapper.writeValueAsString(RequestDto.builder().satellites(satellites).build());
        given(solutionService.getLocation(any(List.class))).willReturn(solve);

        controller.perform(post(SolutionController.BASE_URL_TRACKING)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andDo(document("tracking",
                        responseFields(
                                fieldWithPath("position").description("Located position"),
                                fieldWithPath("position.x").description("x-axis"),
                                fieldWithPath("position.y").description("y-axis"),
                                fieldWithPath("isInDanger").description("Boolean value"))
                ));
    }
}