package com.milo.ms.tracking.service.impl;

import com.milo.ms.tracking.dto.CoordinateDto;
import com.milo.ms.tracking.dto.SatelliteDto;
import com.milo.ms.tracking.service.SolutionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionServiceImpl implements SolutionService {
    @Override
    public CoordinateDto getLocation(List<SatelliteDto> satellites) {
        return null;
    }
}
