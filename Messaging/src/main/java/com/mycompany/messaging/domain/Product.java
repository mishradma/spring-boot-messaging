/**
 *
 */
package com.mycompany.messaging.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author mishradma
 *
 */
@Entity
@Table(name = "product")
@AttributeOverride(name = "uniqueDBID", column = @Column(unique = true, name = "PRODUCT_ID", nullable = false))
public class Product extends PersistableEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6037911238020169507L;
	private String productName;
	private String productDescription;

	/**
	 *
	 */
	public Product() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productName
	 * @param productDescription
	 * @param createdBy
	 * @param lastUpdateBy
	 * @param createDate
	 * @param modifiedDate
	 */
	public Product(final String productName, final String productDescription, final String createdBy,
			final String lastUpdateBy, final Date createDate, final Date modifiedDate) {
		this.setCreatedBy(createdBy);
		this.setLastUpdateBy(lastUpdateBy);
		this.setProductName(productName);
		this.setProductDescription(productDescription);
		this.setCreatedDate(createDate);
		this.setLastModifiedDate(modifiedDate);

	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(final String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription
	 *            the productDescription to set
	 */
	public void setProductDescription(final String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the producId
	 */
	@Transient
	public long getProductId() {
		return this.getUniqueDBID();
	}

	/**
	 * @param productId
	 *            the producId to set
	 */
	@Transient
	public void setProductId(final long productId) {
		this.setUniqueDBID(productId);
	}

}
