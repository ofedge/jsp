package com.vicitf.springboot.param;

/**
 * 属性参数
 * 
 * @author vicitf
 *
 */
public class PropertyVo {
	private String key;
	private Object value;
	private Condition condition;

	public PropertyVo(String key, Object value) {
		this.key = key;
		this.value = value;
		this.condition = Condition.EQUAL;
	}

	public PropertyVo(String key, Object value, Condition condition) {
		this.key = key;
		this.value = value;
		this.condition = condition;
	}

	public String getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public Condition getCondition() {
		return condition;
	}

	public static enum Condition {
		EQUAL("="), LIKE("like"), MORE_THAN(">"),
		MORE_OR_EQUAL(">="), LESS_THAN("<"), LESS_OR_EQUAL("<=");
		
		private String i;

		private Condition(String i) {
			this.i = i;
		}

		public String toString() {
			return String.valueOf(this.i);
		}
	}

	@Override
	public String toString() {
		return "PropertyVo [key=" + key + ", value=" + value + ", condition="
				+ condition + "]";
	}
	
}
