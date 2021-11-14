package br.com.hugoamac.catalogo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.hugoamac.catalogo.contract.ILogService;
import br.com.hugoamac.catalogo.entity.Log;
import br.com.hugoamac.catalogo.model.MyUserDetails;
import br.com.hugoamac.catalogo.repository.LogRepository;

@Service
public class LogService implements ILogService {

	private LogRepository repository;
	private Logger logger = LoggerFactory.getLogger(LogService.class);

	public LogService(LogRepository repository) {
		this.repository = repository;
	}

	@Override
	public void send(String key, String message) {

		Date date = new Date();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String info = "{'" + key + "': '" + message + "', 'userid': '" + user.getId() + "' , 'date':'" + dateFormat.format(date)
				+ "'}";

		Log log = new Log(info);

		logger.info(info);

		repository.save(log);

	}

	public List<Log> listAll() {
		return repository.findAll();
	}
}
