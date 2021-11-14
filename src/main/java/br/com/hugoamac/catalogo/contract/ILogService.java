package br.com.hugoamac.catalogo.contract;

import java.util.List;

import br.com.hugoamac.catalogo.entity.Log;

public interface ILogService {
	
	public void send(String key, String message);
	
	public List<Log> listAll();

}
