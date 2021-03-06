/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.meera.workflow.db.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.meera.workflow.db.model.Feedback;
import com.meera.workflow.db.model.FeedbackModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Feedback service. Represents a row in the &quot;LS_Feedback&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.meera.workflow.db.model.FeedbackModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FeedbackImpl}.
 * </p>
 *
 * @author LiferaySavvy
 * @see FeedbackImpl
 * @see com.meera.workflow.db.model.Feedback
 * @see com.meera.workflow.db.model.FeedbackModel
 * @generated
 */
public class FeedbackModelImpl extends BaseModelImpl<Feedback>
	implements FeedbackModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a feedback model instance should use the {@link com.meera.workflow.db.model.Feedback} interface instead.
	 */
	public static final String TABLE_NAME = "LS_Feedback";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "feedbackId", Types.BIGINT },
			{ "feedbackDate", Types.TIMESTAMP },
			{ "feedbackText", Types.VARCHAR },
			{ "feedbackSubject", Types.VARCHAR },
			{ "feedBackStatus", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusDate", Types.TIMESTAMP },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT }
		};
	public static final String TABLE_SQL_CREATE = "create table LS_Feedback (uuid_ VARCHAR(75) null,feedbackId LONG not null primary key,feedbackDate DATE null,feedbackText VARCHAR(75) null,feedbackSubject VARCHAR(75) null,feedBackStatus INTEGER,statusByUserId LONG,statusDate DATE null,companyId LONG,groupId LONG,userId LONG)";
	public static final String TABLE_SQL_DROP = "drop table LS_Feedback";
	public static final String ORDER_BY_JPQL = " ORDER BY feedback.feedbackId ASC, feedback.feedbackDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY LS_Feedback.feedbackId ASC, LS_Feedback.feedbackDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.meera.workflow.db.model.Feedback"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.meera.workflow.db.model.Feedback"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.meera.workflow.db.model.Feedback"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long FEEDBACKSTATUS_COLUMN_BITMASK = 2L;
	public static long FEEDBACKTEXT_COLUMN_BITMASK = 4L;
	public static long GROUPID_COLUMN_BITMASK = 8L;
	public static long UUID_COLUMN_BITMASK = 16L;
	public static long FEEDBACKID_COLUMN_BITMASK = 32L;
	public static long FEEDBACKDATE_COLUMN_BITMASK = 64L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.meera.workflow.db.model.Feedback"));

	public FeedbackModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFeedbackId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _feedbackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Feedback.class;
	}

	@Override
	public String getModelClassName() {
		return Feedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("feedbackId", getFeedbackId());
		attributes.put("feedbackDate", getFeedbackDate());
		attributes.put("feedbackText", getFeedbackText());
		attributes.put("feedbackSubject", getFeedbackSubject());
		attributes.put("feedBackStatus", getFeedBackStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusDate", getStatusDate());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long feedbackId = (Long)attributes.get("feedbackId");

		if (feedbackId != null) {
			setFeedbackId(feedbackId);
		}

		Date feedbackDate = (Date)attributes.get("feedbackDate");

		if (feedbackDate != null) {
			setFeedbackDate(feedbackDate);
		}

		String feedbackText = (String)attributes.get("feedbackText");

		if (feedbackText != null) {
			setFeedbackText(feedbackText);
		}

		String feedbackSubject = (String)attributes.get("feedbackSubject");

		if (feedbackSubject != null) {
			setFeedbackSubject(feedbackSubject);
		}

		Integer feedBackStatus = (Integer)attributes.get("feedBackStatus");

		if (feedBackStatus != null) {
			setFeedBackStatus(feedBackStatus);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getFeedbackId() {
		return _feedbackId;
	}

	@Override
	public void setFeedbackId(long feedbackId) {
		_columnBitmask = -1L;

		_feedbackId = feedbackId;
	}

	@Override
	public Date getFeedbackDate() {
		return _feedbackDate;
	}

	@Override
	public void setFeedbackDate(Date feedbackDate) {
		_columnBitmask = -1L;

		_feedbackDate = feedbackDate;
	}

	@Override
	public String getFeedbackText() {
		if (_feedbackText == null) {
			return StringPool.BLANK;
		}
		else {
			return _feedbackText;
		}
	}

	@Override
	public void setFeedbackText(String feedbackText) {
		_columnBitmask |= FEEDBACKTEXT_COLUMN_BITMASK;

		if (_originalFeedbackText == null) {
			_originalFeedbackText = _feedbackText;
		}

		_feedbackText = feedbackText;
	}

	public String getOriginalFeedbackText() {
		return GetterUtil.getString(_originalFeedbackText);
	}

	@Override
	public String getFeedbackSubject() {
		if (_feedbackSubject == null) {
			return StringPool.BLANK;
		}
		else {
			return _feedbackSubject;
		}
	}

	@Override
	public void setFeedbackSubject(String feedbackSubject) {
		_feedbackSubject = feedbackSubject;
	}

	@Override
	public int getFeedBackStatus() {
		return _feedBackStatus;
	}

	@Override
	public void setFeedBackStatus(int feedBackStatus) {
		_columnBitmask |= FEEDBACKSTATUS_COLUMN_BITMASK;

		if (!_setOriginalFeedBackStatus) {
			_setOriginalFeedBackStatus = true;

			_originalFeedBackStatus = _feedBackStatus;
		}

		_feedBackStatus = feedBackStatus;
	}

	public int getOriginalFeedBackStatus() {
		return _originalFeedBackStatus;
	}

	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Feedback.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Feedback toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Feedback)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setUuid(getUuid());
		feedbackImpl.setFeedbackId(getFeedbackId());
		feedbackImpl.setFeedbackDate(getFeedbackDate());
		feedbackImpl.setFeedbackText(getFeedbackText());
		feedbackImpl.setFeedbackSubject(getFeedbackSubject());
		feedbackImpl.setFeedBackStatus(getFeedBackStatus());
		feedbackImpl.setStatusByUserId(getStatusByUserId());
		feedbackImpl.setStatusDate(getStatusDate());
		feedbackImpl.setCompanyId(getCompanyId());
		feedbackImpl.setGroupId(getGroupId());
		feedbackImpl.setUserId(getUserId());

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public int compareTo(Feedback feedback) {
		int value = 0;

		if (getFeedbackId() < feedback.getFeedbackId()) {
			value = -1;
		}
		else if (getFeedbackId() > feedback.getFeedbackId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = DateUtil.compareTo(getFeedbackDate(), feedback.getFeedbackDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Feedback)) {
			return false;
		}

		Feedback feedback = (Feedback)obj;

		long primaryKey = feedback.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		FeedbackModelImpl feedbackModelImpl = this;

		feedbackModelImpl._originalUuid = feedbackModelImpl._uuid;

		feedbackModelImpl._originalFeedbackText = feedbackModelImpl._feedbackText;

		feedbackModelImpl._originalFeedBackStatus = feedbackModelImpl._feedBackStatus;

		feedbackModelImpl._setOriginalFeedBackStatus = false;

		feedbackModelImpl._originalCompanyId = feedbackModelImpl._companyId;

		feedbackModelImpl._setOriginalCompanyId = false;

		feedbackModelImpl._originalGroupId = feedbackModelImpl._groupId;

		feedbackModelImpl._setOriginalGroupId = false;

		feedbackModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Feedback> toCacheModel() {
		FeedbackCacheModel feedbackCacheModel = new FeedbackCacheModel();

		feedbackCacheModel.uuid = getUuid();

		String uuid = feedbackCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			feedbackCacheModel.uuid = null;
		}

		feedbackCacheModel.feedbackId = getFeedbackId();

		Date feedbackDate = getFeedbackDate();

		if (feedbackDate != null) {
			feedbackCacheModel.feedbackDate = feedbackDate.getTime();
		}
		else {
			feedbackCacheModel.feedbackDate = Long.MIN_VALUE;
		}

		feedbackCacheModel.feedbackText = getFeedbackText();

		String feedbackText = feedbackCacheModel.feedbackText;

		if ((feedbackText != null) && (feedbackText.length() == 0)) {
			feedbackCacheModel.feedbackText = null;
		}

		feedbackCacheModel.feedbackSubject = getFeedbackSubject();

		String feedbackSubject = feedbackCacheModel.feedbackSubject;

		if ((feedbackSubject != null) && (feedbackSubject.length() == 0)) {
			feedbackCacheModel.feedbackSubject = null;
		}

		feedbackCacheModel.feedBackStatus = getFeedBackStatus();

		feedbackCacheModel.statusByUserId = getStatusByUserId();

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			feedbackCacheModel.statusDate = statusDate.getTime();
		}
		else {
			feedbackCacheModel.statusDate = Long.MIN_VALUE;
		}

		feedbackCacheModel.companyId = getCompanyId();

		feedbackCacheModel.groupId = getGroupId();

		feedbackCacheModel.userId = getUserId();

		return feedbackCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", feedbackId=");
		sb.append(getFeedbackId());
		sb.append(", feedbackDate=");
		sb.append(getFeedbackDate());
		sb.append(", feedbackText=");
		sb.append(getFeedbackText());
		sb.append(", feedbackSubject=");
		sb.append(getFeedbackSubject());
		sb.append(", feedBackStatus=");
		sb.append(getFeedBackStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.meera.workflow.db.model.Feedback");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackId</column-name><column-value><![CDATA[");
		sb.append(getFeedbackId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackDate</column-name><column-value><![CDATA[");
		sb.append(getFeedbackDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackText</column-name><column-value><![CDATA[");
		sb.append(getFeedbackText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedbackSubject</column-name><column-value><![CDATA[");
		sb.append(getFeedbackSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedBackStatus</column-name><column-value><![CDATA[");
		sb.append(getFeedBackStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Feedback.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Feedback.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _feedbackId;
	private Date _feedbackDate;
	private String _feedbackText;
	private String _originalFeedbackText;
	private String _feedbackSubject;
	private int _feedBackStatus;
	private int _originalFeedBackStatus;
	private boolean _setOriginalFeedBackStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private Date _statusDate;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _columnBitmask;
	private Feedback _escapedModel;
}