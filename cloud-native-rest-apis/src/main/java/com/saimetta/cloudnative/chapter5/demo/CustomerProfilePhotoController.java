package com.saimetta.cloudnative.chapter5.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.concurrent.Callable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/v1/customers/{id}/photo")
public class CustomerProfilePhotoController {

	private File root;
	private final CustomerService customerService;
	private final Log log = LogFactory.getLog(getClass());
	
	public CustomerProfilePhotoController(
			@Value("${upload.dir:${user.home}/images}") String uploadDirectory,
			CustomerService customerService) {
		this.root = new File(uploadDirectory);
		this.customerService = customerService;
		Assert.isTrue(
				root.exists() || root.mkdirs(), 
				String.format("The path %s must exist", root.getAbsolutePath()));
	}
	
	@GetMapping
	public ResponseEntity<Resource> read(@PathVariable Long id) {
		Customer customer = customerService.findById(id);
		File file = getFileForCustomer(customer);
		Assert.isTrue(file.exists(),
				String.format("File %s not found.", file.getAbsolutePath()));
		Resource fileSystemResource = new FileSystemResource(file);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(fileSystemResource);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.PUT })
	Callable<ResponseEntity<?>> write(@PathVariable Long id, @RequestParam MultipartFile file) {
		log.info(String.format("Updaload start /v1/customers/%s/photo (%s bytes)", id, file.getSize()));
		return () -> {
			Customer customer = customerService.findById(id);
			File customerPhoto = getFileForCustomer(customer);
			try (
					InputStream in = file.getInputStream();
					OutputStream out = new FileOutputStream(customerPhoto)
				){
				FileCopyUtils.copy(in, out);
			}catch (IOException ex) {
				throw new RuntimeException(ex);
			}
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(id).toUri();
			log.info(String.format("Upload finished /v1/customers/%s/photo (%s)", id, location));
			return ResponseEntity.created(location).build();
		};			 
	}
	
	private File getFileForCustomer(Customer customer) {
		return new File(root,Long.toString(customer.getId()));
	}
	
}
