package com.trustaml.dataservice.ttr.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.repository.ITtrBaseRepository;
import com.trustaml.dataservice.ttr.dao.ITtrDAO;
import com.trustaml.dataservice.ttr.model.TtrLegal;
import com.trustaml.dataservice.ttr.model.TtrNatural;
import com.trustaml.dataservice.ttr.model.Ttr;
import com.trustaml.dataservice.ttr.model.TtrBase;
import com.trustaml.dataservice.ttr.model.TtrInfo;

@Service("ttrService")
public class TtrServiceImpl implements ITtrService {

	@Autowired
	ITtrDAO ttrDao;

	@Autowired
	ITtrBaseRepository ttrRepository;

	@Override
	public TtrBase findById(Long id) throws Exception {
		return ttrRepository.findOne(id);
	}

	@Override
	public List<TtrBase> findAll() throws Exception {
		return ttrRepository.findAll();
	}

	@Override
	public void save(org.json.simple.JSONObject object) throws Exception {
		TtrBase ttrBase = new TtrBase();
		Set<Ttr> ttrSet = new HashSet<>();
		JSONObject obje = new JSONObject(object.toString());

		JSONObject ttrJson = obje.getJSONObject("data");
		ttrJson.keySet().stream().forEach(tr -> {
			Ttr ttr = new Ttr();
			ttr.setTtrBase(ttrBase);
			ttr.setDatatype(tr);
			ttr.setNatural(getNatural(ttrJson.getJSONObject(tr).getJSONObject("natural"), ttr));
			ttr.setLegal(getLegal(ttrJson.getJSONObject(tr).getJSONObject("legal"), ttr));
			ttrSet.add(ttr);
		});

		ttrBase.setTtr(ttrSet);
		ttrDao.saveOrUpdate(ttrBase);

	}

	private TtrNatural getNatural(JSONObject obj, Ttr ttr) {
		TtrNatural natural = new TtrNatural();
		Set<TtrInfo> infoList = new HashSet<>();

		natural.setDescription(obj.getString("description"));
		natural.setThreshold(obj.getDouble("threshold"));
		natural.setType(obj.getString("type"));
		natural.setTtr(ttr);
		JSONObject result = obj.getJSONObject("result");
		result.keySet().stream().forEach(res -> {
			JSONArray accounts = result.getJSONObject(res).getJSONArray(res);
			accounts.forEach(account -> infoList.add(getTtrInfo((JSONObject) account, natural, null)));
		});
		natural.setTtrInfo(infoList);
		return natural;
	}

	private TtrLegal getLegal(JSONObject obj, Ttr ttr) {
		TtrLegal legal = new TtrLegal();
		Set<TtrInfo> infoList = new HashSet<>();

		legal.setDescription(obj.getString("description"));
		legal.setThreshold(obj.getDouble("threshold"));
		legal.setType(obj.getString("type"));
		legal.setTtr(ttr);

		JSONObject result = obj.getJSONObject("result");
		result.keySet().stream().forEach(res -> {
			JSONArray accounts = result.getJSONObject(res).getJSONArray(res);
			accounts.forEach(account -> infoList.add(getTtrInfo((JSONObject) account, null, legal)));
		});

		legal.setTtrInfo(infoList);
		return legal;
	}

	private TtrInfo getTtrInfo(JSONObject account, TtrNatural natural, TtrLegal legal) {
		TtrInfo info = new TtrInfo();
		if (natural != null)
			info.setNatural(natural);
		if (legal != null)
			info.setLegal(legal);

		info.setAccountNo(account.getString("account_no"));
		info.setAccountType(account.getString("account_type"));
		info.setAccountTypeType(account.getString("account_type_type"));
		info.setAmount(account.getDouble("amount"));
		info.setApprovedBy(account.getString("approved_by"));
		info.setAvvsCode(account.getString("abbs_code"));
		info.setBranchSolId(account.getString("branch_sol_id"));
		info.setChequeNo(account.getString("cheque_no"));
		info.setCityCode(account.getString("city_code"));
		info.setCurrencyCode(account.getString("currency_code"));
		info.setCustCode(account.getString("cust_code"));
		info.setDescription(account.getString("description"));
		info.setEnteredBy(account.getString("entered_by"));
		info.setExtraChequeNo(account.getString("extra_cheque_no"));
		info.setKycId(account.getString("kyc_id"));
		info.setLocalCurrencyAmount(account.getDouble("local_currency_amount"));
		info.setNostroBranchId(account.getString("nostro_branch_id"));
		info.setNotes(account.getString("notes"));
		info.setNotice(account.getString("notice"));
		info.setRateCode(account.getString("rate_code"));
		info.setReferenceNo(account.getString("reference_no"));
		info.setSequenceNo(account.getString("sequence_no"));
		info.setSourceOfFund(account.getString("source_of_fund"));
		info.setStatus(account.getString("status"));
		info.setTransType(account.getString("trans_type"));
		info.setTransCategory(account.getString("trans_category"));
		info.setTransCurrencyCode(account.getString("trans_currency_code"));
		info.setTransDate(account.getString("trans_date"));
		info.setTransDest(account.getString("trans_dest"));
		info.setTransDetail(account.getString("trans_detail"));
		info.setTransId(account.getString("trans_id"));
		info.setTransInstrument(account.getString("trans_instrument"));
		info.setTransSource(account.getString("trans_source"));
		info.setTransSubCategory(account.getString("trans_sub_category"));

		return info;
	}

}
