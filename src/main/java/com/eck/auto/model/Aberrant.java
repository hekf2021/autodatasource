package com.eck.auto.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the aberrant database table.
 * 
 */
@Entity
@Table(name="aberrant")
public class Aberrant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="aberrant_id")
	private Integer aberrantId;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@Column(name="order_no")
	private Integer orderNo;

	private String reason;

	public Integer getAberrantId() {
		return this.aberrantId;
	}

	public void setAberrantId(Integer aberrantId) {
		this.aberrantId = aberrantId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


}