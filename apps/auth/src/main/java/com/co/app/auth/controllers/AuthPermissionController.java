/**
 * 
 */
package com.co.app.auth.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.app.auth.dto.AuthPermissionDto;
import com.co.app.auth.services.permission.AuthPermissionService;
import com.co.app.commons.controllers.BasePagedController;
import com.co.app.commons.dto.PageableQueryDto;

/**
 * @author alobaton
 *
 */
@RestController
@RequestMapping("/permissions")
public class AuthPermissionController implements BasePagedController<AuthPermissionDto> {

	@Autowired
	private AuthPermissionService service;

	@Override
	public AuthPermissionDto create(@Valid AuthPermissionDto dto) {
		return service.create(dto);
	}

	@Override
	public AuthPermissionDto get(String id) {
		return service.get(id);
	}

	@Override
	public List<AuthPermissionDto> getAll(Optional<AuthPermissionDto> dto) {
		if (dto.isPresent()) {
			return service.getAll(dto.get());
		}

		return service.getAll();
	}

	@Override
	public AuthPermissionDto update(String id, @Valid AuthPermissionDto dto) {
		dto.setId(id);

		return service.update(dto);
	}

	@Override
	public void delete(String id) {
		service.delete(id);

	}

	@Override
	public Page<AuthPermissionDto> getAll(PageableQueryDto<AuthPermissionDto> request) {
		if (request.getDto().isPresent()) {
			AuthPermissionDto dto = request.getDto().get();
			return service.getAll(dto, request.getPageable().getPageable());
		}

		return service.getAll(request.getPageable().getPageable());
	}

}
