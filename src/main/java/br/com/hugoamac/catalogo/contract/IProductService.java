package br.com.hugoamac.catalogo.contract;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
public interface IProductService {
	
	public boolean saveDataFromFile(MultipartFile file);
}
