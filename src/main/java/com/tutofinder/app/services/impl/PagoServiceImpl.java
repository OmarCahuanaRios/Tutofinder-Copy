package com.tutofinder.app.services.impl;

import com.tutofinder.app.dto.PagoDto;
import com.tutofinder.app.dto.create.CreatePagoDto;
import com.tutofinder.app.entity.*;
import com.tutofinder.app.exception.BookingException;
import com.tutofinder.app.exception.InternalServerErrorException;
import com.tutofinder.app.exception.NotFoundException;
import com.tutofinder.app.repository.*;
import com.tutofinder.app.services.PagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    PagoRepository pagoRepository;

    @Autowired
    TarjetaRepository tarjetaRepository;

    @Autowired
    PadreRepository padreRepository;

    @Autowired
    ReservaRepository reservaRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public PagoDto getPagoById(Long pagoId) throws BookingException {
        return modelMapper.map(getPagoEntity(pagoId), PagoDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PagoDto> getPagos() throws BookingException {
        List<Pago> pagoEntity = pagoRepository.findAll();
        return pagoEntity.stream().map(service -> modelMapper.map(service, PagoDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PagoDto createPago(CreatePagoDto createPagoDto) throws BookingException {
        final Tarjeta tarjeta = tarjetaRepository.findById(createPagoDto.getTarjetaId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "TARJETA_NOT_FOUND"));
        final Padre padre = padreRepository.findById(createPagoDto.getPadreId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "PADRE_NOT_FOUND"));
        final Reserva reserva = reservaRepository.findById(createPagoDto.getPadreId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESERVA_NOT_FOUND"));

        Pago pagoEntity = new Pago();
        Long id;
        pagoEntity.setDescripcionPago(createPagoDto.getDescripcionPago());
        pagoEntity.setCostoPago(createPagoDto.getCostoPago());
        pagoEntity.setPadre(padre);
        pagoEntity.setReserva(reserva);
        pagoEntity.setTarjeta(tarjeta);
        try {
            id = pagoRepository.save(pagoEntity).getId();
        } catch (final Exception e) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getPagoEntity(id), PagoDto.class);
    }

    /* No necesario */
    @Override
    @Transactional
    public PagoDto updatePago(CreatePagoDto createPagoDto, Long pagoId) throws BookingException {
        final Tarjeta tarjeta = tarjetaRepository.findById(createPagoDto.getTarjetaId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "TARJETA_NOT_FOUND"));
        final Padre padre = padreRepository.findById(createPagoDto.getPadreId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "PADRE_NOT_FOUND"));
        final Reserva reserva = reservaRepository.findById(createPagoDto.getPadreId())
                .orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESERVA_NOT_FOUND"));

        Optional<Pago> pago = pagoRepository.findById(pagoId);
        if (!pago.isPresent()) {
            throw new NotFoundException("ID_NOT_FOOUND", "ID_NOT_FOUND");
        }
        Pago pagoEntity = pago.get();
        Long id;
        pagoEntity.setDescripcionPago(createPagoDto.getDescripcionPago());
        pagoEntity.setCostoPago(createPagoDto.getCostoPago());
        pagoEntity.setPadre(padre);
        pagoEntity.setReserva(reserva);
        pagoEntity.setTarjeta(tarjeta);
        try {
            id = pagoRepository.save(pagoEntity).getId();
        } catch (final Exception e) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getPagoEntity(id), PagoDto.class);
    }

    @Override
    public String deletePago(Long pagoId) throws BookingException {
        pagoRepository.findById(pagoId).orElseThrow(() -> new NotFoundException("SNOT-404-1", "PAGO_NOT_FOUND"));
        try {
            pagoRepository.deleteById(pagoId);
        } catch (final Exception e) {
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }
        return "PAGO_DELETED";
    }

    public Pago getPagoEntity(Long pagoId) throws BookingException {
        return pagoRepository.findById(pagoId).orElseThrow(() -> new NotFoundException("SNOT-404-1", "PAGO_NOT_FOUND"));
    }
}
