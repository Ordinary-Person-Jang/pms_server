package com.aiden.pms.domain.pjt.service;

import com.aiden.pms.domain.pjt.repository.PjtRepository;
import com.aiden.pms.domain.pjt.dto.PjtInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PjtInfoService {

    private final PjtRepository pjtRepository;
    public List<PjtInfoDto> selectPjtList() {
        return pjtRepository.selectPjtList();
    }

}
