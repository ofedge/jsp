package com.vicitf.springboot.param;

import java.util.List;

/**
 * 排序参数
 * 
 * @author vicitf
 *
 */
public class SortVo {
	private List<OrderVo> orders;

	public List<OrderVo> getOrders() {
		return orders;
	}
	
	public SortVo(List<OrderVo> orders) {
		this.orders = orders;
	}

	public static class OrderVo {
		private String property;
		private DirectionVo direction;
		
		public OrderVo(String property) {
			this.property = property;
			this.direction = DirectionVo.ASC;
		}

		public OrderVo(String property, DirectionVo direction) {
			this.property = property;
			this.direction = direction;
		}

		public String getProperty() {
			return property;
		}

		public DirectionVo getDirection() {
			return direction;
		}

		@Override
		public String toString() {
			return "Order [property=" + property + ", direction=" + direction
					+ "]";
		}

	}

	public static enum DirectionVo {
		ASC, DESC
	}

	@Override
	public String toString() {
		return "SortVo [orders=" + orders + "]";
	}

}
