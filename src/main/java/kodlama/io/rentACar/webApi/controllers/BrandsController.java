package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
         this.brandService.add(createBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        this.brandService.deleteById(id);
    }

    @DeleteMapping("/deletebyname/{brandName}")
    public void deleteByName(@PathVariable String brandName) throws Exception {
        this.brandService.deleteByName(brandName);
    }

}
