package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.FundDto;
import com.app.entity.CampaignEntity;
import com.app.entity.FundEntity;
import com.app.entity.NgoEntity;
import com.app.repositories.CampaignRepository;
import com.app.repositories.FundRepository;
import com.app.repositories.NgoRepository;

@Service
public class FundService {
	@Autowired
    private FundRepository fundRepository;
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Autowired
	private NgoRepository ngoRepository;
	

    @Autowired
    private ModelMapper modelMapper;
    
    @Transactional(readOnly = true)
    
    public FundDto getfundById(Long id, Long campaignId, Long ngoId) {
        // Fetch the campaign and NGO entities
        CampaignEntity campaignEntity = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));
        NgoEntity ngoEntity = ngoRepository.findById(ngoId)
                .orElseThrow(() -> new RuntimeException("NGO not found"));

        // Fetch the fund entity
        FundEntity fund = fundRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fund not found"));

        // Map the fund entity to FundDto
        FundDto fundDto = modelMapper.map(fund, FundDto.class);

        // Set the campaign and NGO IDs in the DTO
        fundDto.setCampaignId(campaignEntity.getId());
        fundDto.setNgoId(ngoEntity.getId());

        return fundDto;
    }

    
    @Transactional(readOnly = true)
    public List<FundDto> getAllFunds(Long campaignId, Long ngoId) {
        // Fetch the CampaignEntity by its ID
        CampaignEntity campaignEntity = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        // Fetch the NgoEntity by its ID
        NgoEntity ngoEntity = ngoRepository.findById(ngoId)
                .orElseThrow(() -> new RuntimeException("NGO not found"));

        // Fetch the funds by campaignId and ngoId (assuming such a method exists in the repository)
        return fundRepository.findAll().stream()
                .map(fund -> {
                    FundDto fundDto = modelMapper.map(fund, FundDto.class);
                    fundDto.setCampaignId(campaignEntity.getId());
                    fundDto.setNgoId(ngoEntity.getId());
                    return fundDto;
                })
                .collect(Collectors.toList());
    }

    
    @Transactional
    public FundDto createfund(FundDto fundDto, Long campaignId, Long ngoId) {
        // Fetch the campaign entity
        CampaignEntity campaignEntity = campaignRepository.findById(campaignId)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        // Fetch the NGO entity
        NgoEntity ngoEntity = ngoRepository.findById(ngoId)
                .orElseThrow(() -> new RuntimeException("NGO not found"));

        // Map FundDto to FundEntity
        FundEntity fundEntity = modelMapper.map(fundDto, FundEntity.class);

        // Set campaign and NGO entities
        fundEntity.setCampaign(campaignEntity);
        fundEntity.setNgo(ngoEntity);

        // Save the FundEntity
        fundEntity = fundRepository.save(fundEntity);

        // Map updated FundEntity back to FundDto
        FundDto fundDto1 = modelMapper.map(fundEntity, FundDto.class);

        // Set campaignId and ngoId in FundDto
        fundDto1.setCampaignId(campaignEntity.getId());
        fundDto1.setNgoId(ngoEntity.getId());

        return fundDto1;
    }

    
    @Transactional
    public FundDto updatefund(Long id, FundDto fundDetails, Long campaignId, Long ngoId) {
    	 CampaignEntity campaignEntity = campaignRepository.findById(campaignId)
                 .orElseThrow(() -> new RuntimeException("Campaign not found"));

         // Fetch the NgoEntity by its ID
         NgoEntity ngoEntity = ngoRepository.findById(ngoId)
                 .orElseThrow(() -> new RuntimeException("NGO not found"));
         
         FundEntity fundEntity = modelMapper.map(fundDetails, FundEntity.class);

         // Set campaign and NGO entities
         fundEntity.setCampaign(campaignEntity);
         fundEntity.setNgo(ngoEntity);

         // Log values before saving
         System.out.println("Before save: " + fundEntity);

         // Save the FundEntity
         fundEntity = fundRepository.save(fundEntity);

         // Log values after saving
         System.out.println("After save: " + fundEntity);

         // Map updated FundEntity back to FundDto
         FundDto fundDto1 = modelMapper.map(fundEntity, FundDto.class);

         // Set campaignId and ngoId in FundDto
         fundDto1.setCampaignId(campaignEntity.getId());
         fundDto1.setNgoId(ngoEntity.getId());

         return fundDto1;
     }
    @Transactional
    public void deletefund(Long id) {
    	
        FundEntity fund = fundRepository.findById(id).orElseThrow(() -> new RuntimeException("fund not found"));
        fundRepository.delete(fund);
    }
}

