package com.revisao.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.ecommerce.dto.PedidoDTO;
import com.revisao.ecommerce.dto.ProdutoDTO;
import com.revisao.ecommerce.services.PedidoService;

@RestController
@RequestMapping
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@PostMapping(value = "/pedido")
	public ResponseEntity<PedidoDTO> insert(@RequestBody PedidoDTO dto){
		 dto = pedidoService.inserir(dto);
		 return ResponseEntity.ok(dto);
	}
	
}
