package com.trustaml.dataservice.adversemedia.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityInfo {

	private long id;

//	@JsonProperty("hot_list_entity_info_id")
//	private long hotlistEntityInfoId;

	@JsonProperty("published_date")
	private Date publishedDate;

	@JsonProperty("company")
	private String company;

	@JsonProperty("media_source")
	private String mediaSource;

	@JsonProperty("attachment_name")
	private String attachmentName;

	@JsonProperty("adverse_type")
	private String adverseType;

	@JsonProperty("notes")
	private String notes;

	@JsonProperty("reason")
	private String reason;

	@JsonProperty("maker")
	private String maker;

	@JsonProperty("checker")
	private String checker;

	@JsonProperty("approved")
	private boolean approved;

	@JsonProperty("update_date")
	private Date updateDate;

	@JsonProperty("approved_date")
	private Date approvedDate;

	public EntityInfo(long id, long hotlistEntityInfoId, Date publishedDate, String company, String mediaSource,
			String attachmentName, String adverseType, String notes, String reason, String maker, String checker,
			boolean approved, Date updateDate, Date approvedDate) {
		super();
		this.id = id;
	//	this.hotlistEntityInfoId = hotlistEntityInfoId;
		this.publishedDate = publishedDate;
		this.company = company;
		this.mediaSource = mediaSource;
		this.attachmentName = attachmentName;
		this.adverseType = adverseType;
		this.notes = notes;
		this.reason = reason;
		this.maker = maker;
		this.checker = checker;
		this.approved = approved;
		this.updateDate = updateDate;
		this.approvedDate = approvedDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public long getHotlistEntityInfoId() {
//		return hotlistEntityInfoId;
//	}
//
//	public void setHotlistEntityInfoId(long hotlistEntityInfoId) {
//		this.hotlistEntityInfoId = hotlistEntityInfoId;
//	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAdverseType() {
		return adverseType;
	}

	public void setAdverseType(String adverseType) {
		this.adverseType = adverseType;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getMediaSource() {
		return mediaSource;
	}

	public void setMediaSource(String mediaSource) {
		this.mediaSource = mediaSource;
	}

}
