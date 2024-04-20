package com.construction.cmsfresher.service;

import com.construction.cmsfresher.model.CmsPlan;
import com.construction.cmsfresher.model.CmsPlanHistory;

public interface IPlanHistoryService {

	public CmsPlanHistory saveCmsPlanHistory(CmsPlan cmsPlan);
}
