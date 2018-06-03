/**
 *
 */
package com.mycompany.messaging.domain;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author mishradma
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "sales")
@AttributeOverride(name = "uniqueDBID", column = @Column(unique = true, name = "TRANSACTION_ID", nullable = false))
public class Sales extends PersistableEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1287543445084093440L;

	@ManyToOne
	private Product product;
	@Column
	private Long quantity;
	@Column
	private Double rate;

	@Transient
	public Double getTotalValue() {
		return (ObjectUtils.defaultIfNull(quantity, Long.valueOf(0)))
				* ObjectUtils.defaultIfNull(rate, Double.valueOf("0"));
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(final Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public Long getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(final Long quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the rate
	 */
	public Double getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            the rate to set
	 */
	public void setRate(final Double rate) {
		this.rate = rate;
	}

	/**
	 * @return the transactionId
	 */
	@Transient
	public long getTransactionId() {
		return this.getUniqueDBID();
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(final long transactionId) {
		this.setUniqueDBID(transactionId);
	}
}
