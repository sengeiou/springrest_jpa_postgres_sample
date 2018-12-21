package com.trustaml.dataservice.bfi.bank.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.bfi.bank.dao.IBfiDAO;
import com.trustaml.dataservice.bfi.bank.model.Bfi;

@Service("bfiService")
public class BfiServiceImpl implements IBfiService{
	
	@Autowired
	IBfiDAO bfiDao;

	@Override
	public Bfi findById(Long id) throws Exception {
		return bfiDao.findById(id);
	}

	@Override
	public List<Bfi> findAll() throws Exception {
		return bfiDao.findAll();
	}

	@Override
	public void saveOrUpdate(Bfi bfi) throws Exception {
		if(bfi.getBfiInfo() != null)
			bfi.getBfiInfo().setBfi(bfi);
		
		bfi.getBfiAddress().stream().filter(Objects::nonNull).forEach(r -> r.setBfi(bfi));
		bfi.getBfiContact().stream().filter(Objects::nonNull).forEach(r -> r.setBfi(bfi));
		bfi.getBfiEmail().stream().filter(Objects::nonNull).forEach(r -> r.setBfi(bfi));
		
		bfiDao.saveOrUpdate(bfi);
		
	}

}
