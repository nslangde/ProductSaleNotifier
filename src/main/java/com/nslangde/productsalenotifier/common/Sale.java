package com.nslangde.productsalenotifier.common;

import com.nslangde.productsalenotifier.type.ProductType;

/**
 * 
 * Sales bean
 * 
 */
public class Sale {

	private ProductType productType;
	
	private int pricePerProduct;
	
	private int quantity;
	
	/**
	 * @param productType
	 * @param pricePerProduct
	 * @param quantity
	 */
	public Sale(ProductType productType, int pricePerProduct, int quantity) {
		super();
		this.productType = productType;
		this.pricePerProduct = pricePerProduct;
		this.quantity = quantity;
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
	 * @return the pricePerProduct
	 */
	public int getPricePerProduct() {
		return pricePerProduct;
	}

	/**
	 * @param pricePerProduct the pricePerProduct to set
	 */
	public void setPricePerProduct(int pricePerProduct) {
		this.pricePerProduct = pricePerProduct;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sale info : Product=");
		builder.append(productType);
		builder.append(", Price per product=");
		builder.append(pricePerProduct);
		builder.append(", Quantity=");
		builder.append(quantity);
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pricePerProduct;
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + quantity;
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
		Sale other = (Sale) obj;
		if (pricePerProduct != other.pricePerProduct)
			return false;
		if (productType != other.productType)
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
}
