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
		private Direction direction;
		
		public OrderVo(String property) {
			this.property = property;
			this.direction = Direction.ASC;
		}

		public OrderVo(String property, Direction direction) {
			this.property = property;
			this.direction = direction;
		}

		public String getProperty() {
			return property;
		}

		public Direction getDirection() {
			return direction;
		}

		@Override
		public String toString() {
			return "Order [property=" + property + ", direction=" + direction
					+ "]";
		}

	}

	public static enum Direction {
		ASC, DESC
	}

	@Override
	public String toString() {
		return "SortVo [orders=" + orders + "]";
	}

}
