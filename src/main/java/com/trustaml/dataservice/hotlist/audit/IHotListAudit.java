package com.trustaml.dataservice.hotlist.audit;

import java.util.List;

import com.trustaml.dataservice.hotlist.model.HotList;

public interface IHotListAudit {

	public List<HotList> findHotListLog(Long id) throws Exception;

}
