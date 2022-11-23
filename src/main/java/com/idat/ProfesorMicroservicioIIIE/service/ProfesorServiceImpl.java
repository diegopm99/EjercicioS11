package com.idat.ProfesorMicroservicioIIIE.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ProfesorMicroservicioIIIE.dto.ProfesorDTO;
import com.idat.ProfesorMicroservicioIIIE.model.Profesor;
import com.idat.ProfesorMicroservicioIIIE.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public List<ProfesorDTO> listar() {
		List<ProfesorDTO> listaDto = new ArrayList<>();
		ProfesorDTO profesorDto = null;
		
		for (Profesor profesor: repository.findAll()) {
			profesorDto = new ProfesorDTO();
			profesorDto.setIdDto(profesor.getIdProfesor());
			profesorDto.setNombresDto(profesor.getNombres());
			profesorDto.setApellidosDto(profesor.getApellidos());
			listaDto.add(profesorDto);
		}
		return listaDto;
	}

	@Override
	public ProfesorDTO obtener(Integer id) {
		Profesor profesor = repository.findById(id).orElse(null);
		ProfesorDTO profesorDto = new ProfesorDTO();
		profesorDto.setIdDto(profesor.getIdProfesor());
		profesorDto.setNombresDto(profesor.getNombres());
		profesorDto.setApellidosDto(profesor.getApellidos());
		
		return profesorDto;
	}

	@Override
	public void registrar(ProfesorDTO profesorDto) {
		Profesor profesor = new Profesor();
		profesor.setNombres(profesorDto.getNombresDto());
		profesor.setApellidos(profesorDto.getApellidosDto());
		repository.save(profesor);
	}

	@Override
	public void actualizar(ProfesorDTO profesorDto) {
		Profesor profesor = new Profesor();
		profesor.setIdProfesor(profesorDto.getIdDto());
		profesor.setNombres(profesorDto.getNombresDto());
		profesor.setApellidos(profesorDto.getApellidosDto());
		repository.saveAndFlush(profesor);
	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
	}

}
