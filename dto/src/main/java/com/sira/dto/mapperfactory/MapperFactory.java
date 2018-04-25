package com.sira.dto.mapperfactory;

import java.util.HashMap;
import java.util.Map;


import com.sira.dto.common.DTO;
import com.sira.dto.common.SiraMapper;

public class MapperFactory {

	private static Map<Transformer,Map< ?extends SiraMapper,DTO>> MapperMap = new HashMap<>();

	private MapperFactory() {}
	
	public MapperFactory CreateFactory() {
		return new MapperFactory();
	}

	public Map<Transformer, Map<? extends SiraMapper, DTO>> getMapperMap() {
		return MapperMap;
	}
	
}
