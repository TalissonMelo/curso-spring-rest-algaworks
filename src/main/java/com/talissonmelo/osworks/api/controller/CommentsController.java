package com.talissonmelo.osworks.api.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.Comments;
import com.talissonmelo.osworks.domain.service.OrderOfServiceService;
import com.talissonmelo.osworks.model.dto.CommentsDTO;
import com.talissonmelo.osworks.model.dto.CommentsInputDTO;

@RestController
@RequestMapping(value = "/orders/{id}/comments")
public class CommentsController {

	@Autowired
	private OrderOfServiceService service;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CommentsDTO insert(@PathVariable Long id,@Valid @RequestBody CommentsInputDTO dto) {
		Comments comments = service.addComments(id, dto.getDescription());
		
		return fromDTO(comments);
	}

	private CommentsDTO fromDTO(Comments comments) {
		return modelMapper.map(comments, CommentsDTO.class);
	}
}
