package com.nslangde.productsalenotifier.common;

import com.nslangde.productsalenotifier.type.AdjustmentType;
import com.nslangde.productsalenotifier.type.ProductType;

/**
 * 
 * Adjustments bean
 * 
 * @author nikhillangde
 *
 */
public class Adjustment {
	
	private AdjustmentType adjustmentType;
	
	private ProductType productType;
	
	private int adjustmentFactor;
	
	/**
	 * 
	 */
	public Adjustment() {
		super();
	}

	/**
	 * @param adjustmentType
	 * @param productType
	 * @param adjustmentFactor
	 */
	public Adjustment(AdjustmentType adjustmentType, ProductType productType, int adjustmentFactor) {
		super();
		this.adjustmentType = adjustmentType;
		this.productType = productType;
		this.adjustmentFactor = adjustmentFactor;
	}

	/**
	 * @return the adjustmentType
	 */
	public AdjustmentType getAdjustmentType() {
		return adjustmentType;
	}

	/**
	 * @param adjustmentType the adjustmentType to set
	 */
	public void setAdjustmentType(AdjustmentType adjustmentType) {
		this.adjustmentType = adjustmentType;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/**
	 * @return the adjustmentFactor
	 */
	public int getAdjustmentFactor() {
		return adjustmentFactor;
	}

	/**
	 * @param adjustmentFactor the adjustmentFactor to set
	 */
	public void setAdjustmentFactor(int adjustmentFactor) {
		this.adjustmentFactor = adjustmentFactor;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Adjustment of Type= ");
		builder.append(adjustmentType);
		builder.append(" onto product= ");
		builder.append(productType);
		builder.append(" with adjustmentFactor= ");
		builder.append(adjustmentFactor);
		builder.append(".");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adjustmentFactor;
		result = prime * result + ((adjustmentType == null) ? 0 : adjustmentType.hashCode());
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
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
		Adjustment other = (Adjustment) obj;
		if (adjustmentFactor != other.adjustmentFactor)
			return false;
		if (adjustmentType != other.adjustmentType)
			return false;
		if (productType != other.productType)
			return false;
		return true;
	}
	
}
