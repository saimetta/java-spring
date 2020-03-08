package com.santiago.aimetta.authorApi;


public class AuthorDto {

	private Long id;
	private String name;
	private AddressDto address;


	
	public AuthorDto() {}
	
	
	public AuthorDto(String name, AddressDto adress) {
		super();
		this.name = name;
		this.address = adress;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto adress) {
		this.address = adress;
	}

	public Long getId() {
		return id;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AuthorDto other = (AuthorDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
