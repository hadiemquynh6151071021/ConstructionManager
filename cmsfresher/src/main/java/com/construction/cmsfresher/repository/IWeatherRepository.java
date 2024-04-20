package com.construction.cmsfresher.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.cmsfresher.model.MdWeather;

public interface IWeatherRepository extends JpaRepository<MdWeather, Integer>{

}
