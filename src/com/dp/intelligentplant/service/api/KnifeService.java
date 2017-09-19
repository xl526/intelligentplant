package com.dp.intelligentplant.service.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dp.intelligentplant.domain.Knife;
import com.dp.intelligentplant.util.PageVO;

public interface KnifeService {
	
	public void saveKnife(Knife knife);
	
	public void deleteKnife(Long id);
	
	public Page<Knife> findKnifeByPage(Pageable pageable);
	
	public Page<Knife> findKnifeByPageAndParams(PageVO<Knife> pageVO, final Knife knife);
	
}
