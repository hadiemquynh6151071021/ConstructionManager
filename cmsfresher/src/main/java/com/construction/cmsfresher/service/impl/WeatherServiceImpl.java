package com.construction.cmsfresher.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.cmsfresher.model.MdShift;
import com.construction.cmsfresher.model.MdWeather;
import com.construction.cmsfresher.repository.IShiftRepository;
import com.construction.cmsfresher.repository.IWeatherRepository;
import com.construction.cmsfresher.service.IWeatherService;

@Service
public class WeatherServiceImpl implements IWeatherService{
	@Autowired
	IWeatherRepository weatherRepository;
	
	@Autowired
	IShiftRepository shirtRepository;
	@Override
	public MdWeather save(MdWeather entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MdWeather findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MdWeather> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MdWeather> findAllWeather() {
		// TODO Auto-generated method stub
		return weatherRepository.findAll();
	}

	@Override
	public List<MdShift> findAllShirt() {
		// TODO Auto-generated method stub
		return shirtRepository.findAll();
	}
	
}
