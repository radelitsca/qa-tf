package io.swagger.petstore.payloads.pet;

import java.util.List;
import lombok.Data;

@Data
public class PetRequest{
	private List<String> photoUrls;
	private String name;
	private int id;
	private Category category;
	private List<TagsItem> tags;
	private String status;
}