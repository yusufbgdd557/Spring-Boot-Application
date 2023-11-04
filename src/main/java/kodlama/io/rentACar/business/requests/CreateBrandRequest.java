package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {

    private String name;

    //Son kullanıcının bana ürünün "Id"sini söylemesini isteyemem. Id tomatik artıyor.
    //Buradaki olay "Son Kullanıcı"nın veri girmesi.
    //Son kullanıcıdan DATA alıyorsam "REQUEST"
    //Son kullanıcıya DATA dönüyorsam ya da veriyorsam "RESPONSE"
}
