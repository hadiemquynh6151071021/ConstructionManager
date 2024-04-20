package com.construction.cmsfresher.service;

import java.util.List;
import java.util.Optional;

import com.construction.cmsfresher.dto.response.mdconstructionsitedto.MdConstructionSiteDTO;
import com.construction.cmsfresher.model.MdConstructionSite;

public interface IConstructionSiteService extends DaoService<MdConstructionSiteDTO, Integer> {

	public List<MdConstructionSiteDTO> findAllActiveConstructionsSite(Optional<Integer> id);


	public MdConstructionSite findByIdMdConstructionSite(Integer id);
}
