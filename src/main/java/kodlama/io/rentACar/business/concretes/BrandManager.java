package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //Bu sınıf bir Business nesnesidir.
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {

        //Manuel Mapping
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponses = new ArrayList<>();
        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);
        }
        return brandsResponses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {

        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());

        this.brandRepository.save(brand);
    }

    @Override
    public void deleteById(int id) {
        this.brandRepository.deleteById(id);
    }

    @Override
    public void deleteByName(String brandName) throws Exception{
        List<Brand> brands = brandRepository.findAll();
        boolean brandNotFound = true;
        for (Brand brandToDelete : brands) {
            if (brandToDelete.getName().equalsIgnoreCase(brandName)){
                this.brandRepository.delete(brandToDelete);
                brandNotFound = false;
                break;
            }
            if(brandNotFound){
                throw new Exception("There is no such brand with this name --> " + brandName);
            }
        }
    }
}
