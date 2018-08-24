package by.epam.domain.order;

import by.epam.domain.user.User;

public class Offering {

	private final String description;
	private final String isDelete;
	private final String titleOrder;
	private final User user;
	private final int idOrder;

	public String getDescription() {
		return description;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public String getTitleOrder() {
		return titleOrder;
	}

	public User getUser() {
		return user;
	}

	public int getIdOrder() {
		return idOrder;
	}

	private Offering(Builder builder) {
		this.description = builder.description;
		this.isDelete = builder.isDelete;
		this.titleOrder = builder.titleOrder;
		this.user = builder.user;
		this.idOrder = builder.idOrder;
	}

	public static class Builder {
		private String description;
		private String isDelete;
		private String titleOrder;
		private User user;
		private int idOrder;

		public Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder setIsDelete(String isDelete) {
			this.isDelete = isDelete;
			return this;
		}

		public Builder setTitleOrder(String titleOrder) {
			this.titleOrder = titleOrder;
			return this;
		}

		public Builder setUser(User user) {
			this.user = user;
			return this;
		}

		public Builder setIdOrder(int idOrder) {
			this.idOrder = idOrder;
			return this;
		}

		public Offering build() {
			return new Offering(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + idOrder;
		result = prime * result + ((isDelete == null) ? 0 : isDelete.hashCode());
		result = prime * result + ((titleOrder == null) ? 0 : titleOrder.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offering other = (Offering) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idOrder != other.idOrder)
			return false;
		if (isDelete == null) {
			if (other.isDelete != null)
				return false;
		} else if (!isDelete.equals(other.isDelete))
			return false;
		if (titleOrder == null) {
			if (other.titleOrder != null)
				return false;
		} else if (!titleOrder.equals(other.titleOrder))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
