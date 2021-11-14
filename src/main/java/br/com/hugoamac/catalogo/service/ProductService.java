package br.com.hugoamac.catalogo.service;

import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.RFC4180Parser;
import com.opencsv.RFC4180ParserBuilder;

import br.com.hugoamac.catalogo.contract.IProductService;
import br.com.hugoamac.catalogo.entity.Product;
import br.com.hugoamac.catalogo.repository.ProductRepository;

@Service
@Transactional
public class ProductService implements IProductService {

	final static String EXTENSION_CSV = "csv";

	@Value("${imageDir}")
	private String IMAGE_DIR;

	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}

	public Page<Product> listAll(int pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 50);

		return repository.findAll(pageable);
	}

	public Page<Product> findByNameContaining(String name, int pageNumber) {
		
		Pageable pageable = PageRequest.of(pageNumber - 1, 50);

		return repository.findByNameContaining(name, pageable);
	}

	public boolean saveDataFromFile(MultipartFile file) {

		boolean result = false;

		String extension = FilenameUtils.getExtension(file.getOriginalFilename());

		if (extension.equalsIgnoreCase(ProductService.EXTENSION_CSV)) {
			result = readDataFromCsv(file);
		}

		return result;
	}

	private boolean readDataFromCsv(MultipartFile file) {
		try {

			InputStreamReader readerStream = new InputStreamReader(file.getInputStream());
			RFC4180Parser rfc4180Parser = new RFC4180ParserBuilder().build();
			CSVReader readerCSV = new CSVReaderBuilder(readerStream).withCSVParser(rfc4180Parser).withSkipLines(1)
					.build();

			List<String[]> rows = readerCSV.readAll();

			for (String[] row : rows) {

				Product product = new Product();

				product.setCodIn(StringToLong(row[0]));
				product.setCodTablet(StringToLong(row[1]));
				product.setName(row[2]);
				product.setCodSupplier(StringToLong(row[3]));
				product.setSupplier(row[4]);
				product.setBarUnity(row[5]);
				product.setBarBox(row[6]);
				product.setEanDisplay(row[7]);
				product.setWeightUnity(row[8]);
				product.setWeightBuy(row[9]);
				product.setHeigth(row[10]);
				product.setWidth(row[11]);
				product.setDepth(row[12]);
				product.setMultipleSale(row[13]);
				product.setNcm(row[14]);

				String img = replacePathImage(row[15]);

				product.setImg(img);
				product.setPdv1(row[16].equalsIgnoreCase("x") ? true : false);
				product.setPdv2(row[17].equalsIgnoreCase("x") ? true : false);
				product.setPdv3(row[18].equalsIgnoreCase("x") ? true : false);
				product.setPdv4(row[19].equalsIgnoreCase("x") ? true : false);
				product.setPdv5(row[20].equalsIgnoreCase("x") ? true : false);
				product.setPdv6(row[21].equalsIgnoreCase("x") ? true : false);
				product.setPdv7(row[22].equalsIgnoreCase("x") ? true : false);
				product.setPdv8(row[23].equalsIgnoreCase("x") ? true : false);
				product.setPdv9(row[24].equalsIgnoreCase("x") ? true : false);
				product.setPdv10(row[25].equalsIgnoreCase("x") ? true : false);
				product.setPdv11(row[26].equalsIgnoreCase("x") ? true : false);
				product.setPdv12(row[27].equalsIgnoreCase("x") ? true : false);
				product.setPdv13(row[28].equalsIgnoreCase("x") ? true : false);
				product.setPdv14(row[29].equalsIgnoreCase("x") ? true : false);
				product.setPdv15(row[30].equalsIgnoreCase("x") ? true : false);

				this.repository.save(product);
			}

			return true;

		} catch (Exception e) {

			System.out.println("Error:" + e.getMessage());

			return false;
		}
	}

	private String replacePathImage(String pathFile) {

		if (pathFile.equals("")) {
			return pathFile;
		}

		String[] splitPath = pathFile.split(Pattern.quote("\\"));

		String fileName = splitPath[splitPath.length - 1];

		return this.IMAGE_DIR.concat(fileName);

	}

	private Long StringToLong(String val) {
		if (val.equals("") || val == null) {
			return 0L;
		}

		return Long.parseLong(val);
	}

}
