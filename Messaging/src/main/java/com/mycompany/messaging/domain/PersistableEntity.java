/**
 *
 */
package com.mycompany.messaging.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author mishradma
 *
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersistableEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -7393943846395576435L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long uniqueDBID;

	@CreatedBy
	private String createdBy;
	@CreatedDate
	private Date createdDate;
	@LastModifiedBy
	private String lastUpdateBy;
	@LastModifiedDate
	private Date lastModifiedDate;

	/**
	 * @return the uniqueDBID
	 */
	@JsonIgnore
	public long getUniqueDBID() {
		return uniqueDBID;
	}

	/**
	 * @param uniqueDBID
	 *            the uniqueDBID to set
	 */
	public void setUniqueDBID(final long uniqueDBID) {
		this.uniqueDBID = uniqueDBID;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the lastUpdateBy
	 */
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	/**
	 * @param lastUpdateBy
	 *            the lastUpdateBy to set
	 */
	public void setLastUpdateBy(final String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	/**
	 * @return the lastModifiedDate
	 */
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	/**
	 * @param lastModifiedDate
	 *            the lastModifiedDate to set
	 */
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
