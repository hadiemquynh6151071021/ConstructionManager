package com.construction.cmsfresher.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.dto.response.mdconstructionsitedto.MdConstructionSiteDTO;
import com.construction.cmsfresher.model.MdConstructionSite;
import com.construction.cmsfresher.repository.IConstructionSiteRepository;
import com.construction.cmsfresher.service.IConstructionSiteService;
import com.construction.cmsfresher.service.MapperConverter;

@Service
public class ConstructionSiteServiceImpl
		implements IConstructionSiteService, MapperConverter<MdConstructionSiteDTO, MdConstructionSite> {

	@Autowired
	IConstructionSiteRepository constructionSiteRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public MdConstructionSiteDTO save(MdConstructionSiteDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MdConstructionSiteDTO findById(Integer id) {
		// TODO Auto-generated method stub
		MdConstructionSite constructionSite = constructionSiteRepository.findById(id).orElse(null);
		MdConstructionSiteDTO constructionSiteDTO = this.convertEntityToDto(constructionSite);
		return constructionSiteDTO != null ? constructionSiteDTO : null;
	}

	@Override
	public List<MdConstructionSiteDTO> findAll() {
		List<MdConstructionSite> list = constructionSiteRepository.findAll();
		List<MdConstructionSiteDTO> mdConstructionSiteDTOs = new ArrayList<>();
		list.forEach(i -> {
			mdConstructionSiteDTOs.add(this.convertEntityToDto(i));
		});
		return mdConstructionSiteDTOs.size() > 0 ? mdConstructionSiteDTOs : null;
	}

	@Override
	public List<MdConstructionSiteDTO> findAllActiveConstructionsSite(Optional<Integer> id) {
		if (id.isEmpty()) {
			List<MdConstructionSite> list = constructionSiteRepository.findAll();
			List<MdConstructionSiteDTO> mdConstructionSiteDTOs = new ArrayList<>();
			list.forEach(i -> {
				mdConstructionSiteDTOs.add(this.convertEntityToDto(i));
			});
			return mdConstructionSiteDTOs;
		}
		List<MdConstructionSite> list = constructionSiteRepository.findAllActiveConstructionsSite(id);
		List<MdConstructionSiteDTO> mdConstructionSiteDTOs = new ArrayList<>();
		list.forEach(i -> {
			mdConstructionSiteDTOs.add(this.convertEntityToDto(i));
		});
		return mdConstructionSiteDTOs.size() > 0 ? mdConstructionSiteDTOs : null;
	}

	@Override
	public MdConstructionSite findByIdMdConstructionSite(Integer id) {
		// TODO Auto-generated method stub
		MdConstructionSite constructionSite = constructionSiteRepository.findById(id).orElse(null);
		return constructionSite != null ? constructionSite : null;
	}

	@Override
	public MdConstructionSiteDTO convertEntityToDto(MdConstructionSite entity) {
		// TODO Auto-generated method stub
		MdConstructionSiteDTO constructionSiteDTO = new MdConstructionSiteDTO();
		constructionSiteDTO = modelMapper.map(entity, MdConstructionSiteDTO.class);
		return constructionSiteDTO;
	}

	@Override
	public MdConstructionSite convertDtoToEntity(MdConstructionSiteDTO dto) {
		// TODO Auto-generated method stub
		MdConstructionSite constructionSite = new MdConstructionSite();
		constructionSite = modelMapper.map(dto, MdConstructionSite.class);
		return constructionSite;
	}

}
