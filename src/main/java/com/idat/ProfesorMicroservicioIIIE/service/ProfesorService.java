package com.idat.ProfesorMicroservicioIIIE.service;

import java.util.List;

import com.idat.ProfesorMicroservicioIIIE.dto.ProfesorDTO;

public interface ProfesorService {

	public List<ProfesorDTO> listar();
	public ProfesorDTO obtener(Integer id);
	public void registrar(ProfesorDTO profesorDto);
	public void actualizar(ProfesorDTO profesorDto);
	public void eliminar(Integer id);
}
