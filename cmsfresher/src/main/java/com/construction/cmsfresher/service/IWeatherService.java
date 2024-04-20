package com.construction.cmsfresher.service;

import java.util.List;

import com.construction.cmsfresher.model.MdShift;
import com.construction.cmsfresher.model.MdWeather;

public interface IWeatherService extends DaoService<MdWeather, Integer>{
	public List<MdWeather> findAllWeather();
	
	public List<MdShift> findAllShirt();
}
