package com.tutofinder.app.services.impl;

import com.tutofinder.app.dto.InformeDto;
import com.tutofinder.app.dto.create.CreateInformeDto;
import com.tutofinder.app.entity.Informe;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.exception.InternalServerErrorException;
import com.tutofinder.app.exception.NotFoundException;
import com.tutofinder.app.repository.InformeRepository;
import com.tutofinder.app.services.InformeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InformeServiceImpl implements InformeService {
    @Autowired
    InformeRepository informeRepository;

    public static final ModelMapper modelMapper= new ModelMapper();

    @Override
    public InformeDto getInformeById(Long informeId) throws BookingException {
        return modelMapper.map(getInformeEntity(informeId),InformeDto.class);
    }

    @Override
    public List<InformeDto> getInformes() throws BookingException {
        final List<Informe> informesEntity = informeRepository.findAll();
        return informesEntity.stream().map(service -> modelMapper.map(service,InformeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public InformeDto createInforme(CreateInformeDto createInformeDto) throws BookingException {
        Informe informeEntity;
        Informe informe = new Informe();
        informe.setDescripcionInforme(createInformeDto.getDescripcionInforme());
        try {
            informeEntity=informeRepository.save(informe);
        } catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getInformeEntity(informeEntity.getId()),InformeDto.class);
    }

    @Override
    public InformeDto updateInforme(CreateInformeDto createInformeDto, Long informeId) throws BookingException {
        Optional<Informe> informe = informeRepository.findById(informeId);
        if(!informe.isPresent()){
            throw new NotFoundException("ID_NOT_FOOUND","ID_NOT_FOUND");
        }
        Informe informeEntity = informe.get();
        informeEntity.setDescripcionInforme(createInformeDto.getDescripcionInforme());
        try {
            informeRepository.save(informeEntity);
        }
        catch (final Exception e){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getInformeEntity(informeEntity.getId()),InformeDto.class);
    }

    @Override
    public String deleteInforme(Long informeId) throws BookingException {
        informeRepository.findById(informeId)
                .orElseThrow(()->new NotFoundException("ID_NOT_FOOUND","ID_NOT_FOUND"));
        try {
            informeRepository.deleteById(informeId);
        }catch (Exception ex){
            throw  new InternalServerErrorException("INTERNAL_ERROR","INTERNAL_ERROR");
        }

        return "INFORME_DELETED";
    }

    private Informe getInformeEntity(Long informeId) throws BookingException{
        return informeRepository.findById(informeId)
                .orElseThrow(()-> new NotFoundException("SNOT-404-1","INFORME_NOT_FOUND"));
    }
}
