package com.tutofinder.app.services.impl;

import com.tutofinder.app.entity.Padre;
import com.tutofinder.app.repository.PadreRepository;
import com.tutofinder.app.services.PadreService;
import org.springframework.stereotype.Service;

@Service
public class PadreServiceImpl extends CommonServiceImpl<Padre, PadreRepository> implements PadreService {
}
