package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.PetDTO;
import com.tecsup.petclinic.exceptions.PetNotFoundException;

import java.util.List;

/**
 * 
 * @author jgomezm
 *
 */
public interface PetService {

	/**
	 * 
	 * @param petDTO
	 * @return
	 */
	public PetDTO create(PetDTO petDTO);

	/**
	 * 
	 * @param pet
	 * @return
	 */
	PetDTO update(PetDTO pet) throws PetNotFoundException;

	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	void delete(Integer id) throws PetNotFoundException;

	/**
	 * 
	 * @param id
	 * @return
	 */
	PetDTO findById(Integer id) throws PetNotFoundException;

	/**
	 * 
	 * @param name
	 * @return
	 */
	List<PetDTO> findByName(String name);

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	List<PetDTO> findByTypeId(int typeId);

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	List<PetDTO> findByOwnerId(int ownerId);

	/**
	 *
	 * @return
	 */
	List<PetDTO> findAll();
}
