package com.aspirecoders.instock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.aspirecoders.instock.service.BrandService;
import com.aspirecoders.instock.model.Brand;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BrandController {

  @Autowired
  private BrandService brandService;

  @GetMapping("/brands")
  public ResponseEntity<List<Brand>> getAllBrands() {
    List<Brand> brands = brandService.getAllBrands();

    if (brands.size() == 0) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(brands, HttpStatus.OK);
  }

  @GetMapping("/brands/{id}")
  public ResponseEntity<Brand> getBrandById(@PathVariable long id) {
    Optional<Brand> brand = brandService.getBrandById(id);

    if (!brand.isPresent()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(brand.get(), HttpStatus.OK);
  }

  @PostMapping("/brands")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
    Brand createdBrand = brandService.createBrand(brand);
    return new ResponseEntity<>(createdBrand, HttpStatus.CREATED);
  }

  @PutMapping("/brands/{id}")
  public ResponseEntity<Brand> updateBrand(@PathVariable long id, @RequestBody Brand brand) {
    Brand updatedBrand = brandService.updateBrand(id, brand);
    return new ResponseEntity<>(updatedBrand, HttpStatus.OK);
  }

  @DeleteMapping("/brands/{id}")
  public ResponseEntity<Void> deleteBrand(@PathVariable long id) {
    brandService.deleteBrand(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
