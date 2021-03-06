package org.snomed.authoringtemplate.domain.logical;

public class Attribute implements HasCardinality {

	private String type;
	private String value;
	private String allowableRangeECL;
	private String cardinalityMin;
	private String cardinalityMax;
	private String slotName;
	private String slotReference;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setAllowableRangeECL(String allowableRangeECL) {
		this.allowableRangeECL = allowableRangeECL;
	}

	public String getAllowableRangeECL() {
		return allowableRangeECL;
	}

	@Override
	public void setCardinalityMin(String cardinalityMin) {
		this.cardinalityMin = cardinalityMin;
	}

	@Override
	public void setCardinalityMax(String cardinalityMax) {
		this.cardinalityMax = cardinalityMax;
	}

	public String getCardinalityMin() {
		return cardinalityMin;
	}

	public String getCardinalityMax() {
		return cardinalityMax;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotReference(String slotReference) {
		this.slotReference = slotReference;
	}

	public String getSlotReference() {
		return slotReference;
	}

	public String toStringVerbose() {
		StringBuilder builder = new StringBuilder();
		builder.append("Attribute [");
		if (type != null)
			builder.append("type=").append(type).append(", ");
		if (value != null)
			builder.append("value=").append(value).append(", ");
		if (allowableRangeECL != null)
			builder.append("allowableRangeECL=").append(allowableRangeECL).append(", ");
		if (cardinalityMin != null)
			builder.append("cardinalityMin=").append(cardinalityMin).append(", ");
		if (cardinalityMax != null)
			builder.append("cardinalityMax=").append(cardinalityMax).append(", ");
		if (slotName != null)
			builder.append("slotName=").append(slotName).append(", ");
		if (slotReference != null)
			builder.append("slotReference=").append(slotReference);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public String toString() {
		return (cardinalityMin == null ? "": "[[~" + cardinalityMin + ".." + cardinalityMax + "]] ")
				+ getType() + " = "
				+ (getValue() == null ? rangeToString() : getValue() );
	}

	private String rangeToString() {
		return "[[+id(" + getAllowableRangeECL() + ") @" + getSlotName() + "]]";
	}
}
