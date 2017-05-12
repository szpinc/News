package com.szp.service;

import java.util.List;

import com.szp.entity.Carousel;

public class CarouselService extends BaseService {

	
	public void update (Carousel carousel) {
		String sql = "UPDATE carousel SET url=?, pic=? WHERE id=?";
		dao.update(sql, carousel.getUrl(),carousel.getPic(),carousel.getId());
	}
	
	public List<Carousel> getAll () {
		return queryAll("carousel", Carousel.class);
	}
	
	
}
