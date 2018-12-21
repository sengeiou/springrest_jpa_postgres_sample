package com.trustaml.dataservice.str.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trustaml.dataservice.str.dao.IStrDAO;
import com.trustaml.dataservice.str.model.Str;
import com.trustaml.dataservice.str.model.StrBase;
import com.trustaml.dataservice.str.model.StrInfo;
import com.trustaml.dataservice.str.model.StrLegal;
import com.trustaml.dataservice.str.model.StrNatural;

@Service("strService")
public class StrServiceImpl implements IStrService {

	@Autowired
	IStrDAO strDao;

	@Override
	public StrBase findById(Long id) throws Exception {
		return strDao.findById(id);
	}

	@Override
	public List<StrBase> findAll() throws Exception {
		return strDao.findAll();
	}

	@Override
	public void save(org.json.simple.JSONObject object) throws Exception {
		StrBase strBase = new StrBase();
		Set<Str> strSet = new HashSet<>();
		JSONObject obje = new JSONObject(object.toString());

		JSONObject strJson = obje.getJSONObject("data");
		strJson.keySet().stream().forEach(tr -> {
			Str str = new Str();
			str.setStrBase(strBase);
			str.setDatatype(tr);
			str.setNatural(getNatural(strJson.getJSONObject(tr).getJSONObject("natural"), str));
			str.setLegal(getLegal(strJson.getJSONObject(tr).getJSONObject("legal"), str));
			strSet.add(str);
		});

		strBase.setStr(strSet);
		strDao.saveOrUpdate(strBase);

	}

	private StrNatural getNatural(JSONObject obj, Str str) {
		StrNatural natural = new StrNatural();
		Set<StrInfo> infoList = new HashSet<>();

		natural.setDescription(obj.getString("description"));
		natural.setFrequency(obj.getDouble("frequency"));
		natural.setType(obj.getString("type"));
		natural.setDuration(obj.getDouble("duration"));
		try {
			natural.setAmountMax(obj.getDouble("amount_max"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
		try {
			natural.setAmountMin(obj.getDouble("amount_min"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 

		natural.setStr(str);
		JSONObject result = obj.getJSONObject("result");
		result.keySet().stream().forEach(res -> {
			JSONArray accounts = result.getJSONArray(res).getJSONArray(0);
			accounts.forEach(account -> infoList.add(getStrInfo((JSONObject) account, natural, null)));
		});
		natural.setStrInfo(infoList);
		return natural;
	}

	private StrLegal getLegal(JSONObject obj, Str str) {
		StrLegal legal = new StrLegal();
		Set<StrInfo> infoList = new HashSet<>();

		legal.setDescription(obj.getString("description"));
		legal.setFrequency(obj.getDouble("frequency"));
		legal.setType(obj.getString("type"));

		try {
			legal.setAmountMax(obj.getDouble("amount_max"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
		try {
			legal.setAmountMin(obj.getDouble("amount_min"));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} 
		legal.setDuration(obj.getDouble("duration"));
		legal.setStr(str);

		JSONObject result = obj.getJSONObject("result");
		result.keySet().stream().forEach(res -> {
			JSONArray accounts = result.getJSONArray(res).getJSONArray(0);
			accounts.forEach(account -> infoList.add(getStrInfo((JSONObject) account, null, legal)));
		});

		legal.setStrInfo(infoList);
		return legal;
	}

	private StrInfo getStrInfo(JSONObject account, StrNatural natural, StrLegal legal) {
		StrInfo info = new StrInfo();
		if (natural != null)
			info.setNatural(natural);
		if (legal != null)
			info.setLegal(legal);

		info.setAccountNo(account.getString("account_no"));
		info.setAccountType(account.getString("account_type"));
		info.setAccountTypeType(account.getString("account_type_type"));
		info.setAmount(account.getDouble("amount"));
		info.setApprovedBy(account.getString("approved_by"));
		info.setAbbsCode(account.getString("abbs_code"));
		info.setBranchSolId(account.getString("branch_sol_id"));
		info.setChequeNo(account.getString("cheque_no"));
		info.setCityCode(account.getString("city_code"));
		info.setCurrencyCode(account.getString("currency_code"));
		info.setCustCode(account.getString("cust_code"));
		info.setEnteredBy(account.getString("entered_by"));
		info.setExtraChequeNo(account.getString("extra_cheque_no"));
		info.setKycId(account.getString("kyc_id"));
		info.setLocalCurrencyAmount(account.getDouble("local_currency_amount"));
		info.setNotice(account.getString("notice"));
		info.setRateCode(account.getString("rate_code"));
		info.setReferenceNo(account.getString("reference_no"));
		info.setSequenceNo(account.getString("sequence_no"));
		info.setStatus(account.getString("status"));
		info.setTransCategory(account.getString("trans_category"));
		info.setTransCurrencyCode(account.getString("trans_currency_code"));
		info.setTransDate(account.getString("trans_date"));
		info.setTransDetail(account.getString("trans_detail"));
		info.setTransId(account.getString("trans_id"));
		info.setTransInstrument(account.getString("trans_instrument"));
		info.setTransSubCategory(account.getString("trans_sub_category"));

		return info;
	}

}
