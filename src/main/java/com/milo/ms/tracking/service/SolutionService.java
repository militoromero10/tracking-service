package com.milo.ms.tracking.service;

import com.milo.ms.tracking.dto.CoordinateDto;
import com.milo.ms.tracking.dto.SatelliteDto;

import java.util.List;

public interface SolutionService {

    CoordinateDto getLocation(List<SatelliteDto> satellites);

}
