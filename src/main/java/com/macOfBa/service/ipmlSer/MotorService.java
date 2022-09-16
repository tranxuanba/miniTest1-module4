package com.macOfBa.service.ipmlSer;

import com.macOfBa.model.Motor;
import com.macOfBa.repository.ipmlRepo.IMotorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MotorService implements IMotorService {
    @Autowired
    private IMotorRepository motorRepository;

    @Override
    public List<Motor> findAll() {
        return motorRepository.findAll();
    }

    @Override
    public Motor findById(int id) {
        return motorRepository.findById(id);
    }

    @Override
    public void save(Motor motor) {
        motorRepository.save(motor);
    }

    @Override
    public void remove(int id) {
        motorRepository.remove(id);
    }
}
