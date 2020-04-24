package com.talissonmelo.osworks.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.osworks.domain.model.Comments;
import com.talissonmelo.osworks.domain.model.OrderOfService;
import com.talissonmelo.osworks.domain.repository.OrderOfServiceRepository;
import com.talissonmelo.osworks.domain.service.OrderOfServiceService;
import com.talissonmelo.osworks.domain.service.exceptions.EntityNotFoundException;
import com.talissonmelo.osworks.model.dto.CommentsDTO;
import com.talissonmelo.osworks.model.dto.CommentsInputDTO;

@RestController
@RequestMapping(value = "/orders/{id}/comments")
public class CommentsController {

	@Autowired
	private OrderOfServiceService service;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private OrderOfServiceRepository orderRepository;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CommentsDTO insert(@PathVariable Long id, @Valid @RequestBody CommentsInputDTO dto) {
		Comments comments = service.addComments(id, dto.getDescription());

		return fromDTO(comments);
	}

	@GetMapping
	public List<CommentsDTO> findAll(@PathVariable Long id) {
		OrderOfService order = orderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Order de Serviço não encontrada. Id: " + id));
		return toCollectionDTO(order.getComments());
	}

	private CommentsDTO fromDTO(Comments comments) {
		return modelMapper.map(comments, CommentsDTO.class);
	}

	private List<CommentsDTO> toCollectionDTO(List<Comments> comments) {
		return comments.stream().map(comment -> fromDTO(comment)).collect(Collectors.toList());
	}
}
