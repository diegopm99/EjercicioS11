package com.idat.ProfesorMicroservicioIIIE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.ProfesorMicroservicioIIIE.dto.ProfesorDTO;
import com.idat.ProfesorMicroservicioIIIE.service.ProfesorService;

@RestController
@RequestMapping("/profesor/v1")
public class ProfesorController {

	@Autowired
	private ProfesorService service;
	
	@GetMapping("/listar")
	public @ResponseBody List<ProfesorDTO> listar(){
		return service.listar();
	}
	
	@GetMapping("/obtener/{id}")
	public @ResponseBody ProfesorDTO obtener(@PathVariable Integer id){
		return service.obtener(id);
	}
	
	@PostMapping("/registrar")
	public @ResponseBody void guardar(@RequestBody ProfesorDTO profesorDto) {
		service.registrar(profesorDto);
	}
	
	@PutMapping("/actualizar")
	public @ResponseBody void actualizar(@RequestBody ProfesorDTO profesorDto) {
		service.actualizar(profesorDto);
	}
	
	@DeleteMapping("/eliminar/{id}")
	public @ResponseBody void eliminar(@PathVariable Integer id) {
		service.eliminar(id);
	}
}
