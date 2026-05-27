package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.PetDTO;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exceptions.PetNotFoundException;
import com.tecsup.petclinic.mappers.PetMapper;
import com.tecsup.petclinic.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author jgomezm
 *
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

	private final PetRepository petRepository;
	private final PetMapper petMapper;


	/**
	 * 
	 * @param petDTO
	 * @return
	 */
	@Override
	public PetDTO create(PetDTO petDTO) {

		Pet newPet = petRepository.save(petMapper.mapToEntity(petDTO));

		return petMapper.mapToDto(newPet);
	}

	/**
	 * 
	 * @param petDTO
	 * @return
	 */
	@Override
	public PetDTO update(PetDTO petDTO) throws PetNotFoundException {
		if (petDTO.getId() == null || !petRepository.existsById(petDTO.getId())) {
			throw new PetNotFoundException("Pet not found with id: " + petDTO.getId());
		}

		Pet petUpdated = petRepository.save(petMapper.mapToEntity(petDTO));

		return petMapper.mapToDto(petUpdated);

	}


	/**
	 * 
	 * @param id
	 * @throws PetNotFoundException
	 */
	@Override
	public void delete(Integer id) throws PetNotFoundException{

		PetDTO pet = findById(id);

		petRepository.delete(this.petMapper.mapToEntity(pet));

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public PetDTO findById(Integer id) throws PetNotFoundException {

		Optional<Pet> pet = petRepository.findById(id);

		if ( !pet.isPresent())
			throw new PetNotFoundException("Record not found...!");

		return this.petMapper.mapToDto(pet.get());
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	@Override
	public List<PetDTO> findByName(String name) {

		List<Pet> pets = petRepository.findByName(name);

		pets.forEach(pet -> log.info("{}", pet));

		return pets
				.stream()
				.map(this.petMapper::mapToDto)
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param typeId
	 * @return
	 */
	@Override
	public List<PetDTO> findByTypeId(int typeId) {

		List<Pet> pets = petRepository.findByTypeId(typeId);

		pets.forEach(pet -> log.info("{}", pet));

		return pets
				.stream()
				.map(this.petMapper::mapToDto)
				.collect(Collectors.toList());
	}

	/**
	 * 
	 * @param ownerId
	 * @return
	 */
	@Override
	public List<PetDTO> findByOwnerId(int ownerId) {

		List<Pet> pets = petRepository.findByOwnerId(ownerId);

		pets.forEach(pet -> log.info("{}", pet));

		return pets
				.stream()
				.map(this.petMapper::mapToDto)
				.collect(Collectors.toList());
	}

	/**
	 *
	 * @return
	 */
	@Override
	public List<PetDTO> findAll() {
		return petRepository.findAll()
				.stream()
				.map(this.petMapper::mapToDto)
				.collect(Collectors.toList());

	}
}
