package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand,Integer>{
//Interface diğer bir Interface'i "extend" eder.
//Class Interface'in içini doldurur. Onu "implement" eder.
}
