package dibimbing.team2.service.impl;


import dibimbing.team2.model.Barang;
import dibimbing.team2.repository.BarangRepository;
import dibimbing.team2.service.BarangService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class BarangImpl implements BarangService {


    @Autowired
    public BarangRepository barangRepository;

    @Autowired
    public SupplierRepository supplierRepository;

    public static final Logger log = LoggerFactory.getLogger(BarangImpl.class);


    @Autowired
    public com.dibimbing.dibimbing.utils.TemplateResponse templateResponse;

    @Override
    public Map insert(Barang obj) {
        try {
            if (templateResponse.chekNull(obj.getNama())) {
                return templateResponse.templateEror("Nama is Requiered");
            }

            if (templateResponse.chekNull(obj.getHarga())) {
                return templateResponse.templateEror("Harga is requiered");
            }
            Barang barangSave = barangRepository.save(obj);
            return templateResponse.templateSukses(barangSave);
        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }
    }

    @Override
    public Map getAll(int size, int page) {
        try {
            Pageable show_data = PageRequest.of(page, size);
            Page<Barang> list = barangRepository.getAllData(show_data);
            return templateResponse.templateSukses(list);
        } catch (Exception e) {
            log.error("ada eror di method getAll:" + e);
            return templateResponse.templateEror(e);
        }
    }


    @Override
    public Map update(Barang barangReq) {
        try {

            if (templateResponse.chekNull(barangReq.getId())) {
                return templateResponse.templateEror("Id Barang is required");
            }
            Barang chekIdBarang = barangRepository.getbyID(barangReq.getId());
            if (templateResponse.chekNull(chekIdBarang)) {
                return templateResponse.templateEror("Id Barang Not found");
            }

            chekIdBarang.setNama(barangReq.getNama());
            chekIdBarang.setHarga(barangReq.getHarga());
            chekIdBarang.setStok(barangReq.getStok());
            chekIdBarang.setSatuan(barangReq.getSatuan());
            Barang dosave = barangRepository.save(chekIdBarang);

            return templateResponse.templateSukses(dosave);
        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }

    }

    @Override
    public Map insert(Barang barang) {
        return null;
    }

    @Override
    public Map delete(Long barang) {
        try {
            if (templateResponse.chekNull(barang)) {
                return templateResponse.templateEror("Id Barang is required");
            }

            Barang chekIdBarang = barangRepository.getbyID(barang);
            if (templateResponse.chekNull(chekIdBarang)) {
                return templateResponse.templateEror("Id Barang Not found");
            }

            chekIdBarang.setDeleted_date(new Date());//
            barangRepository.save(chekIdBarang);

            return templateResponse.templateSukses("sukses deleted");

        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }
    }

    @Override
    public Map findByNama(String nama, Integer page, Integer size) {
        try {
           /*
           1. buat query dulu where nama barang
            */
            Pageable show_data = PageRequest.of(page, size);
            Page<Barang> list = barangRepository.findByNama(nama, show_data);
            return templateResponse.templateSukses(list);
        } catch (Exception e) {

            log.error("eror disini findByNama : " + e);
            //menampilkan responose
            return templateResponse.templateEror(e);
        }
    }


    @Override
    public Page<Barang> findByNamaLike(String nama, Pageable pageable) {
        try {
           /*
           1. buat query dulu where nama barang = like
            */
            //tidak pake kutip
            //perhatikan tolowercasenya
            Page<Barang> list = barangRepository.findByNamaLike("%" + nama + "%", pageable);
//             public Page<Barang> findByNamaLike(String nama , Pageable pageable);
            return list;
        } catch (Exception e) {
            // manampilkan di terminal saja
            log.error("ada eror di method findByNamaLike:" + e);
            return null;
        }
    }

    @Override
    public Map insert(Barang obj, Long idsupplier) {
        try {
            if (templateResponse.chekNull(obj.getNama())) {
                return templateResponse.templateEror("Nama is Requiered");
            }

            if (templateResponse.chekNull(obj.getHarga())) {
                return templateResponse.templateEror("Harga is requiered");
            }

            if (templateResponse.chekNull(idsupplier)) {
                return templateResponse.templateEror("Id Supplier is requiered");
            }
            Supplier chekId = supplierRepository.getbyID(idsupplier);
            if (templateResponse.chekNull(chekId)) {
                return templateResponse.templateEror("Id Supplier NOt found");
            }
            //do save
            obj.setSupplier(chekId);
            Barang barangSave = barangRepository.save(obj);
            return templateResponse.templateSukses(barangSave);
        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }
    }

    @Override
    public Map update(Barang barangReq, Long idsupplier) {
        try {
/*
1. chek id supplirt - takutnya suppliar tidak ada
2. chek id barang - apakah ada atau tidak di db
3. simpan ke database
 */
            if (templateResponse.chekNull(idsupplier)) {
                return templateResponse.templateEror("Id Supplier is requiered");
            }
//            1. che id supplirt - =takutnyanya suppliar
            Supplier chekId = supplierRepository.getbyID(idsupplier);
            if (templateResponse.chekNull(chekId)) {
                return templateResponse.templateEror("Id Supplier N0t found");
            }
            if (templateResponse.chekNull(barangReq.getId())) {
                return templateResponse.templateEror("Id Barang is required");
            }
//            2. chek id barang - apakah ada atau ga
            Barang chekIdBarang = barangRepository.getbyID(barangReq.getId());
            if (templateResponse.chekNull(chekIdBarang)) {
                return templateResponse.templateEror("Id Barang Not found");
            }
//            3. simpan database : update
            chekIdBarang.setNama(barangReq.getNama());
            chekIdBarang.setHarga(barangReq.getHarga());
            chekIdBarang.setStok(barangReq.getStok());
            chekIdBarang.setSatuan(barangReq.getSatuan());
            Barang dosave = barangRepository.save(chekIdBarang);

            return templateResponse.templateSukses(dosave);
        } catch (Exception e) {
            return templateResponse.templateEror(e);
        }

    }
}
