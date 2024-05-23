package com.ahmet.Monolitik.service;

import com.ahmet.Monolitik.repository.ISatisRepository;
import com.ahmet.Monolitik.repository.entity.Musteri;
import com.ahmet.Monolitik.repository.entity.Satis;
import com.ahmet.Monolitik.repository.entity.Urun;
import com.ahmet.Monolitik.repository.view.VwSatis;
import com.ahmet.Monolitik.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SatisService extends ServiceManager<Satis,Long> {

    private final ISatisRepository repository;
    /**
     * @Autowired
     * Spring bu anotasyon ile işaretlenen sınıfların nesnelerini
     * yaratarak ilgili değişkene atamasını yapar; Bean yönetimini
     * sağlamış olur.
     */
    @Autowired
    private MusteriService musteriService;
    @Autowired
    private UrunService urunService;

    public SatisService(ISatisRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<VwSatis> findAllSatisList() {
        List<Satis> satisList = findAll();
        List<Urun> urunList = urunService.findAll();
        List<Musteri> musteriList = musteriService.findAll();
        List<VwSatis> vwSatisList = new ArrayList<>();
        satisList.forEach(x->{
            String musteriadi =
                    // musteriService.findById(x.getMusteriid()).get().getAd();  --> Bu daha çok maliyetli (düşük performanslı), aşağıdaki yönteme göre. Bu satırda tek bir kayıt çekiyoruz ama, veri tabanına gidip connection'un açılıp kapanması daha çok maliyetli.
                    musteriList.stream()  // daha performanslı.
                    .filter(m->m.getId().equals(x.getMusteriid()))
                    .findFirst().get().getAd();
            String urunadi = urunList.stream()
                    .filter(u->u.getId().equals(x.getUrunid()))
                    .findFirst().get().getAd();
            VwSatis vwsatis = VwSatis.builder()
                    .satisid(x.getId())
                    .urunid(x.getUrunid())
                    .musteriid(x.getMusteriid())
                    .adet(x.getAdet())
                    .birimfiyat(x.getBirimfiyat())
                    .toplamfiyat(x.getToplamfiyat())
                    .musteriadi(musteriadi)
                    .urunadi(urunadi)
                    .build();
            vwSatisList.add(vwsatis);
        });
        return vwSatisList;
    }

}
