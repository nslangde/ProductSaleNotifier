package com.nslangde.productsalenotifier.common;

import com.nslangde.productsalenotifier.common.Adjustment;
import com.nslangde.productsalenotifier.type.MessageType;
import com.nslangde.productsalenotifier.type.ProductType;

/**
 * Message bean
 * 
 */
public class Message {
	
	private MessageType msgType;
	
	private ProductType productType;
	
	private Sale sale;
	
	private Adjustment adjustment;

	/**
	 * @param msgType
	 * @param sale
	 * @param adjustment
	 */
	public Message(MessageType msgType, ProductType productType, Sale sale, Adjustment adjustment) {
		super();
		this.msgType = msgType;
		this.productType = productType;
		this.sale = sale;
		this.adjustment = adjustment;
	}

	public MessageType getMsgType() {
		return msgType;
	}

	public void setMsgType(MessageType msgType) {
		this.msgType = msgType;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Adjustment getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Adjustment adjustment) {
		this.adjustment = adjustment;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [msgType=");
		builder.append(msgType);
		builder.append(", productType=");
		builder.append(productType);
		builder.append(", sale=");
		builder.append(sale);
		builder.append(", adjustment=");
		builder.append(adjustment);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjustment == null) ? 0 : adjustment.hashCode());
		result = prime * result + ((msgType == null) ? 0 : msgType.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (adjustment == null) {
			if (other.adjustment != null)
				return false;
		} else if (!adjustment.equals(other.adjustment))
			return false;
		if (msgType != other.msgType)
			return false;
		if (productType != other.productType)
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		return true;
	}
	
	
}
